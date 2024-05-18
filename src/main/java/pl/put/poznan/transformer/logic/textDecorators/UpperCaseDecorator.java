package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

/**
 * The UpperCaseDecorator class extends TextDecorator and provides a method to transform all letters in a string to uppercase.
 */
public class UpperCaseDecorator extends TextDecorator {

    /**
     * Constructor for the UpperCaseDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public UpperCaseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then transforming all letters to uppercase.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toUpperCase();
    }
}
