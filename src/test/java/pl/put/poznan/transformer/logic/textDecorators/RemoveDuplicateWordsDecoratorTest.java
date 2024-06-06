package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveDuplicateWordsDecoratorTest {
    TextTransformer transformer;
    private MockTransformer mockTransformer;
    @BeforeEach
    public void setUp() {
        mockTransformer = new MockTransformer(1);
        transformer = new RemoveDuplicateWordsDecorator(mockTransformer);
    }

    @Test
    public void two_words() {
        String input = "hello world world";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void case_sensitivity() {
        String input = "HeLLo WoRLd world";
        String result = transformer.transform(input);
        assertEquals("HeLLo WoRLd", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void four_words() {
        String input = "no no no no";
        String result = transformer.transform(input);
        assertEquals("no", result);
        assertTrue(mockTransformer.isDone());
    }


}
