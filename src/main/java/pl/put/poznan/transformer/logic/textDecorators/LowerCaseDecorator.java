package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

public class LowerCaseDecorator extends TextDecorator {
    public LowerCaseDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toLowerCase();
    }
}
