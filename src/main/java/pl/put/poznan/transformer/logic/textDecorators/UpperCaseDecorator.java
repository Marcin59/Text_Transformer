package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

public class UpperCaseDecorator extends TextDecorator {
    public UpperCaseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toUpperCase();
    }
}
