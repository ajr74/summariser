package com.xlrantlabs;

import com.google.common.collect.ImmutableList;
import edu.stanford.nlp.util.CoreMap;

import java.util.Collection;
import java.util.Locale;

/**
 * A basic encapsulation of a text sentence.
 */
public class Sentence
{
    //////////////////////////////////////////////////
    // Fields

    /**
     * The raw text for the sentence, including stop words and punctuation.
     */
    private final String rawText;

    /**
     * The sentences tokens, not including stop words and punctuation.
     */
    private final Collection<String> valuableTokens;

    /**
     * The position of the paragraph this sentence belongs to within the overall document.
     */
    private final int paragraphPositionWithinDoc;

    /**
     * The position of this sentence within the paragraph it resides in.
     */
    private final int positionWithinParagraph;

    /**
     * The importance score assigned to the sentence.
     */
    private float score;

    //////////////////////////////////////////////////
    // Constructors

    /**
     * Constructs the sentence.
     *
     * @param paragraphPositionWithinDoc the position of the paragraph this sentence belongs to within the overall document.
     * @param positionWithinParagraph the position of this sentence within the paragraph it lives.
     * @param coreMap the coreMap instance to extract textual information from.
     */
    public Sentence(int paragraphPositionWithinDoc, int positionWithinParagraph, CoreMap coreMap)
    {
        this.paragraphPositionWithinDoc = paragraphPositionWithinDoc;
        this.positionWithinParagraph = positionWithinParagraph;
        edu.stanford.nlp.simple.Sentence sentence = new edu.stanford.nlp.simple.Sentence(coreMap);
        rawText = sentence.text();
        valuableTokens = sentence.tokens()
                .stream()
                .map(token -> token.word().toLowerCase(Locale.ROOT))
                .filter(token -> token.length() > 1)
                .filter(token -> !StopWords.ENGLISH.contains(token))
                .collect(ImmutableList.toImmutableList());
    }

    /**
     * Gets the raw text for the sentence, including stop words and punctuation.
     *
     * @return the raw text for the sentence, including stop words and punctuation.
     */
    public String getRawText()
    {
        return rawText;
    }

    /**
     * Gets the sentences tokens, not including stop words and punctuation.
     *
     * @return the sentences tokens, not including stop words and punctuation.
     */
    public Collection<String> getValuableTokens()
    {
        return valuableTokens;
    }

    /**
     * Gets the position of the paragraph this sentence belongs to within the overall document.
     *
     * @return the position of the paragraph this sentence belongs to within the overall document.
     */
    public int getParagraphPositionWithinDoc()
    {
        return paragraphPositionWithinDoc;
    }

    /**
     * Gets the position of this sentence within the paragraph it resides in.
     *
     * @return the position of this sentence within the paragraph it resides in.
     */
    public int getPositionWithinParagraph()
    {
        return positionWithinParagraph;
    }

    /**
     * Gets the importance score assigned to the sentence.
     *
     * @return the importance score assigned to the sentence.
     */
    public float getScore()
    {
        return score;
    }

    /**
     * Sets the importance score for the sentence.
     *
     * @param score the score to apply.
     */
    public void setScore(float score)
    {
        this.score = score;
    }
}
