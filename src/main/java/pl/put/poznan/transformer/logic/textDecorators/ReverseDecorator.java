package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;
/**
 * The ReverseDecorator class extends TextDecorator and provides a method to reverse the string.
 */
public class ReverseDecorator extends TextDecorator {
    /**
     * Constructor for the ReverseDecorator class.
     *
     * @param textToTransform The TextTransformer object that this decorator will wrap.
     */
    public ReverseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the given text by applying previous transformation and then reverses the string.
     *
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text){
        text = super.transform(text);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            boolean isUpperCase = Character.isUpperCase(text.charAt(i));
            char newChar = text.charAt(text.length() - 1 - i);
            result.append(isUpperCase ? Character.toUpperCase(newChar) : Character.toLowerCase(newChar));
        }
        return result.toString();
    }
}
