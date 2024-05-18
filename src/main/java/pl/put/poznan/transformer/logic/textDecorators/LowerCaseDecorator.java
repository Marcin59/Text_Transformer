package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

/**
 * The LowerCaseDecorator class extends TextDecorator and provides a method to transform all letters in a string to lowercase.
 */
public class LowerCaseDecorator extends TextDecorator {

    /**
     * Constructor for the LowerCaseDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public LowerCaseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then transforming all letters to lowercase.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toLowerCase();
    }
}
