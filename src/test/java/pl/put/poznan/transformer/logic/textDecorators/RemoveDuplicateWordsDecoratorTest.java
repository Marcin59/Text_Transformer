package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateWordsDecoratorTest {

    @Test
    public void two_words() {
        TextTransformer transformer = new RemoveDuplicateWordsDecorator(new MockTransformer());
        String input = "hello world world";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
    }

    @Test
    public void case_sensitivity() {
        TextTransformer transformer = new RemoveDuplicateWordsDecorator(new MockTransformer());
        String input = "HeLLo WoRLd world";
        String result = transformer.transform(input);
        assertEquals("HeLLo WoRLd", result);
    }

    @Test
    public void four_words() {
        TextTransformer transformer = new RemoveDuplicateWordsDecorator(new MockTransformer());
        String input = "no no no no";
        String result = transformer.transform(input);
        assertEquals("no", result);
    }

    private static class MockTransformer implements TextTransformer {
        @Override
        public String transform(String text) {
            return text;
        }
    }
}
