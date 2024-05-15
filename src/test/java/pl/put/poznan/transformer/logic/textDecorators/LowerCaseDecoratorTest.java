package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseDecoratorTest {

    @Test
    public void transform_AllUpperCaseText_AllLowerCase() {
        TextTransformer transformer = new LowerCaseDecorator(new MockTransformer());
        String input = "HELLO WORLD";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
    }

    @Test
    public void transform_MixedCaseText_AllUpperCase() {
        TextTransformer transformer = new LowerCaseDecorator(new MockTransformer());
        String input = "HeLLo WoRLd";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
    }

    @Test
    public void transform_AllLowerCaseText_Unchanged() {

        TextTransformer transformer = new LowerCaseDecorator(new MockTransformer());
        String input = "hello world";
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
