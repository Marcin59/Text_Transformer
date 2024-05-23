package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.StringTokenizer;

/**
 * The RemoveDuplicateWordsDecorator class extends TextDecorator and provides a method to remove adjacent duplicate words.
 */
public class RemoveDuplicateWordsDecorator extends TextDecorator {
    /**
     * Constructor for the RemoveDuplicateWordsDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public RemoveDuplicateWordsDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then removing adjacent duplicate words.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return removeDuplicateWords(text);
    }

    /**
     * Removes adjacent duplicate words from the given text.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    private String removeDuplicateWords(String text) {
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(text);
        String previousWord = null;

        while (tokenizer.hasMoreTokens()) {
            String currentWord = tokenizer.nextToken();
            if (previousWord == null || !currentWord.equalsIgnoreCase(previousWord)) {
                result.append(currentWord).append(" ");
                previousWord = currentWord;
            }
        }

        // Remove the trailing space
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
