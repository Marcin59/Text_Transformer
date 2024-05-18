package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.*;

public class AcronimsToWordsDecoratorTest {

    @Test
    public void dr_test() {
        TextTransformer transformer = new AcronimsToWordsDecorator(new MockTransformer());
        String input = "dr Smith is a neurosurgeon";
        String result = transformer.transform(input);
        assertEquals("doctor Smith is a neurosurgeon", result);
    }

    @Test
    public void prof_test() {
        TextTransformer transformer = new AcronimsToWordsDecorator(new MockTransformer());
        String input = "prof. McDougal is divorced";
        String result = transformer.transform(input);
        assertEquals("professor McDougal is divorced", result);
    }

    @Test
    public void eg_test() {
        TextTransformer transformer = new AcronimsToWordsDecorator(new MockTransformer());
        String input = "snacks e.g. cheetos";
        String result = transformer.transform(input);
        assertEquals("snacks for example cheetos", result);
    }

    @Test
    public void aso_test() {
        TextTransformer transformer = new AcronimsToWordsDecorator(new MockTransformer());
        String input = "talking about flowers aso";
        String result = transformer.transform(input);
        assertEquals("talking about flowers and so on", result);
    }
    public void aso_dot_test() {
        TextTransformer transformer = new AcronimsToWordsDecorator(new MockTransformer());
        String input = "talking about flowers aso.";
        String result = transformer.transform(input);
        assertEquals("talking about flowers and so on.", result);
    }

    private static class MockTransformer implements TextTransformer {
        @Override
        public String transform(String text) {
            return text;
        }
    }
}
