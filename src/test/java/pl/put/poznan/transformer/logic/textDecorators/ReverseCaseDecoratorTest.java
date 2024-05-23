package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseCaseDecoratorTest {

    @Test
    public void transform_AllLowerCaseText_AllUpperCase() {
        TextTransformer transformer = new ReverseCaseDecorator(new MockTransformer());
        String input = "hello world";
        String result = transformer.transform(input);
        assertEquals("HELLO WORLD", result);
    }

    @Test
    public void transform_MixedCaseText_ReversedCase() {
        TextTransformer transformer = new ReverseCaseDecorator(new MockTransformer());
        String input = "HeLLo WoRLd";
        String result = transformer.transform(input);
        assertEquals("hEllO wOrlD", result);
    }

    @Test
    public void transform_AllUpperCaseText_AllLowerCase() {
        TextTransformer transformer = new ReverseCaseDecorator(new MockTransformer());
        String input = "HELLO WORLD";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
    }

    private static class MockTransformer implements TextTransformer {
        @Override
        public String transform(String text) {
            return text;
        }
    }
}
