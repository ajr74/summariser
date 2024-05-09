# summariser

A basic syntactic text summariser. The logic is based on some rough rules apparently used by the iPhone app "Summly" which is no longer available - IP acquired by Yahoo!

The idea is to regard sentences with a lot of high-frequency tokens as important. Further regard is given to sentences in the first paragraph of the text,
and the first sentence in each paragraph.

There are some terse comments in the code that suggest ways to improve scoring using additional features of the Stanford core NLP lib.

Usage is straightfoward. Create a Summariser object, then give it the text of interest and the max number of summary sentences you want:

    Summariser summariser = new Summariser();
    summariser.summarise(text, 5);

The summary can be easily retrieved:

    String summary = summariser.getSummary();
    
And if you want some elementary document stats:

    int numParagraphs = summariser.getNumParagraphs();
    int numSentences = summariser.getNumSentences();

(c) 2024
