package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

/**
 * The ReverseCaseDecorator class extends TextDecorator and provides a method to reverse cases of  each word in a string.
 */
public class ReverseCaseDecorator extends TextDecorator {
    /**
     * Constructor for the ReverseCaseDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public ReverseCaseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then reverses cases of all the letters in the string.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return  reverse_case(text);
    }

    /**
     * Reverses cases of all the letters in the text
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    private String reverse_case(String text) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}

