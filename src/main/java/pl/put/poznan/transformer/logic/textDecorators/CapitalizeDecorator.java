package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

/**
 * The CapitalizeDecorator class extends TextDecorator and provides a method to capitalize the first letter of each word in a string, and transform other letters to lowercase.
 */
public class CapitalizeDecorator extends TextDecorator {
    /**
     * Constructor for the CapitalizeDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public CapitalizeDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then capitalize the first letter of each word in a string, and transform other letters to lowercase.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        text = text.toLowerCase();
        return capitalize(text);
    }

    /**
     * Capitalizes the first letter of each word in the given text and transforms the rest to lowercase.
     *
     * @param text The text to be capitalized.
     * @return The transformed text.
     */
    private String capitalize(String text) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : text.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                capitalizeNext = true;
                result.append(ch);
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
