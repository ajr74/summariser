package com.xlrantlabs;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A syntactic summariser.
 */
public class Summariser
{
    //////////////////////////////////////////////////
    // Fields

    /**
     * The boost factor to apply to sentences within the first paragraph of the document.
     */
    private static final float FIRST_PARAGRAPH_BOOST = 1.5f;

    /**
     * The boost factor to apply to the first sentence within a paragraph.
     */
    private static final float FIRST_SENTENCE_BOOST = 1.25f;

    /**
     * The paragraph separator.
     */
    private static final String NEW_PARA_SEP = "\n\n";

    /**
     * The raw text to summarise.
     */
    private String text;

    /**
     * The maximum number of summary sentences to return.
     */
    private int limit;

    /**
     * The text sentences.
     */
    private final List<Sentence> sentences = Lists.newArrayList();

    /**
     * The text summary.
     */
    private String summary;

    //////////////////////////////////////////////////
    // Methods

    /**
     * Summarises the supplied text.
     *
     * @param text the text to summariser.
     * @param limit the maximum number of sentences to return.
     */
    public void summarise(String text, int limit)
    {
        this.text = text;
        this.limit = limit;
        sentences.clear();
        summary = "";

        extractSentences();
        scoreSentences();
        assembleSummary();
    }

    /**
     * Gets the text summary.
     *
     * @return the text summary.
     */
    public String getSummary()
    {
        return summary;
    }

    /**
     * Gets the number of paragraphs summarised.
     *
     * @return the number of paragraphs summarised.
     */
    public int getNumParagraphs()
    {
        int numSentences = sentences.size();
        return numSentences == 0 ? 0 : sentences.get(numSentences - 1).getParagraphPositionWithinDoc() + 1;
    }

    /**
     * Gets the number of sentences summarised.
     *
     * @return the number of sentences summarised.
     */
    public int getNumSentences()
    {
        return sentences.size();
    }

    /**
     * Extracts sentences from the current text.
     */
    private void extractSentences()
    {
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit");  // can add more here for trickier scoring: parts of speech, named entities, etc
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation document = new Annotation(text);
        pipeline.annotate(document);

        int paragraphPositionWithinDoc = 0;
        int positionWithinParagraph = 0;
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class))
        {
            int sentenceOffsetStart = sentence.get(CoreAnnotations.CharacterOffsetBeginAnnotation.class);
            if (sentenceOffsetStart > 1 && text.startsWith(NEW_PARA_SEP, sentenceOffsetStart - NEW_PARA_SEP.length()) && !sentences.isEmpty())
            {
                paragraphPositionWithinDoc++;
                positionWithinParagraph = 0;
            }
            sentences.add(new Sentence(paragraphPositionWithinDoc, positionWithinParagraph++, sentence));
        }
    }

    /**
     * Scores the sentences. The implementation here is a simple one, based on rules mentioned by the author of an old
     * iPhone app called "Summly" (no longer available). In general sentences containing high-frequency words are good.
     * Sentences in the first paragraph should be scored higher, as often a lot of summary information is in the first
     * paragraph. The first sentences in each paragraph should be scored higher, too.
     *
     * CoreNLP lets one annotate tokens with parts-of-speech (noun, verb, adjective, etc) and named entity info. Such
     * annotations could be used to enhance the scorer below.
     */
    private void scoreSentences()
    {
        Multiset<String> documentTokenHistogram = HashMultiset.create();
        sentences.forEach(sentence -> documentTokenHistogram.addAll(sentence.getValuableTokens()));
        long numTotalTokens = documentTokenHistogram.entrySet().stream().map(Multiset.Entry::getCount).count();
        Preconditions.checkArgument(numTotalTokens > 0L, "No tokens in the supplied text");

        sentences.forEach(sentence -> {
            float score = sentence.getValuableTokens()
                    .stream()
                    .map(documentTokenHistogram::count)
                    .reduce(0, Integer::sum) / (float) numTotalTokens;

            if (sentence.getParagraphPositionWithinDoc() == 0)
            {
                score *= FIRST_PARAGRAPH_BOOST;
            }
            if (sentence.getPositionWithinParagraph() == 0)
            {
                score *= FIRST_SENTENCE_BOOST;
            }

            sentence.setScore(score);
        });
    }

    /**
     * Assembles the summary based on the highest scoring sentences.
     */
    private void assembleSummary()
    {
        // First, get the top scoring sentences.
        Collection<Sentence> highestScoringSentences = sentences.stream()
                .sorted((s1, s2) -> Float.compare(s2.getScore(), s1.getScore()))
                .limit(limit)
                .collect(Collectors.toList());

        // Then rearrange the top scoring sentences, so that they can be joined in presentation order.
        Iterable<String> reorderedResults = highestScoringSentences.stream()
                .sorted((s1, s2) -> {
                    int paragraphCompare = Integer.compare(s1.getParagraphPositionWithinDoc(), s2.getParagraphPositionWithinDoc());
                    if (paragraphCompare == 0)
                    {
                        return Integer.compare(s1.getPositionWithinParagraph(), s2.getPositionWithinParagraph());
                    }
                    return paragraphCompare;
                })
                .map(Sentence::getRawText)
                .map(String::trim)
                .map(sentence -> sentence.replaceAll("\\R+", " "))
                .collect(Collectors.toList());

        summary = Joiner.on(' ').join(reorderedResults);
    }
}
