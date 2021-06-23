package com.xlrantlabs;

import com.google.common.collect.ImmutableSet;

import java.util.Collection;

/**
 * Utility class for stop words.
 */
public class StopWords
{
    //////////////////////////////////////////////////
    // Fields

    /**
     * Basic stop words with minimum size of 2. (Defaults for Lucene and Elasticsearch.)
     */
    public static final Collection<String> ENGLISH =
            ImmutableSet.of("an", "and", "are", "as", "at", "be", "but", "by",
            "for", "if", "in", "into", "is", "it",
            "no", "not", "of", "on", "or", "such",
            "that", "the", "their", "then", "there", "these",
            "they", "this", "to", "was", "will", "with");

    //////////////////////////////////////////////////
    // Constructors

    /**
     * Prevent instantiation.
     */
    private StopWords()
    {
    }
}
