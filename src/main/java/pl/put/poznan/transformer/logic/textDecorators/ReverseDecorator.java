package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

public class ReverseDecorator extends TextDecorator {

    public ReverseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

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
