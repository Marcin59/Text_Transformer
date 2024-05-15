package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapitalizeDecoratorTest {

    @Test
    public void transform_AllLowerCaseText_CapitalizeCase() {
        TextTransformer transformer = new CapitalizeDecorator(new MockTransformer());
        String input = "hello world";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
    }

    @Test
    public void transform_MixedCaseText_CapitalizeCase() {
        TextTransformer transformer = new CapitalizeDecorator(new MockTransformer());
        String input = "HeLLo WoRLd";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
    }

    @Test
    public void transform_CapitalizeCaseText_Unchanged() {
        TextTransformer transformer = new CapitalizeDecorator(new MockTransformer());
        String input = "Hello World";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
    }

    private static class MockTransformer implements TextTransformer {
        @Override
        public String transform(String text) {
            return text;
        }
    }
}
