package com.xlrantlabs;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;
import java.util.stream.Collectors;

public class Summariser
{
    //////////////////////////////////////////////////
    // Fields

    /**
     * The boost to apply to sentences within the first paragraph of the document.
     */
    private static final float FIRST_PARAGRAPH_BOOST = 1.5f;

    /**
     * The boost to apply to the first sentence within a paragraph.
     */
    private static final float FIRST_SENTENCE_BOOST = 1.25f;

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
    private final Collection<Sentence> sentences = Lists.newArrayList();

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
     * @return the summarised text.
     */
    public String summarise(String text, int limit)
    {
        this.text = text;
        this.limit = limit;
        sentences.clear();

        extractSentences();
        scoreSentences();
        assembleSummary();

        return summary;
    }

    /**
     * Extracts sentences from the current text.
     */
    private void extractSentences()
    {
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        Annotation document = new Annotation(text);
        pipeline.annotate(document);

        int paragraphPositionWithinDoc = 0;
        int positionWithinParagraph = 0;
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class))
        {
            int sentenceOffsetStart = sentence.get(CoreAnnotations.CharacterOffsetBeginAnnotation.class);
            if (sentenceOffsetStart > 1 && text.startsWith("\n\n", sentenceOffsetStart - 2) && !sentences.isEmpty())
            {
                paragraphPositionWithinDoc++;
                positionWithinParagraph = 0;
            }
            sentences.add(new Sentence(paragraphPositionWithinDoc, positionWithinParagraph++, sentence));
        }
    }

    /**
     * Scores the sentences based on token frequencies and sentence position information.
     */
    private void scoreSentences()
    {
        Multiset<String> documentTokenHistogram = HashMultiset.create();
        sentences.forEach(sentence -> documentTokenHistogram.addAll(sentence.getValuableTokens()));
        long numTotalTokens = documentTokenHistogram.entrySet().stream().map(Multiset.Entry::getCount).count();

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
        Collection<Sentence> highestScoringSentences = sentences.stream()
                .sorted((s1, s2) -> Float.compare(s2.getScore(), s1.getScore()))
                .limit(limit)
                .collect(Collectors.toList());

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
                .collect(Collectors.toList());

        summary = Joiner.on(' ').join(reorderedResults);
    }
}
