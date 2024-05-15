package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

public class CapitalizeDecorator extends TextDecorator {
    public CapitalizeDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }
    @Override
    public String transform(String text) {
        text = super.transform(text);
        text = text.toLowerCase();
        return capitalize(text);
    }

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
