package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.*;

public class AcronymsToWordsDecoratorTest {
    private TextTransformer transformer;
    private MockTransformer mockTransformer;
    @BeforeEach
    public void setUp() {
        mockTransformer = new MockTransformer(1);
        transformer = new AcronymsToWordsDecorator(mockTransformer);
    }

    @Test
    public void dr_test() {
        String input = "dr Smith is a neurosurgeon";
        String result = transformer.transform(input);
        assertEquals("doctor Smith is a neurosurgeon", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void prof_test() {
        String input = "prof. McDougal is divorced";
        String result = transformer.transform(input);
        assertEquals("professor McDougal is divorced", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void eg_test() {
        String input = "snacks e.g. cheetos";
        String result = transformer.transform(input);
        assertEquals("snacks for example cheetos", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void aso_test() {
        String input = "talking about flowers aso";
        String result = transformer.transform(input);
        assertEquals("talking about flowers and so on", result);
        assertTrue(mockTransformer.isDone());
    }
    @Test
    public void aso_dot_test() {
        String input = "talking about flowers aso.";
        String result = transformer.transform(input);
        assertEquals("talking about flowers and so on.", result);
        assertTrue(mockTransformer.isDone());
    }
    @Test
    public void case_test() {
        String input = "snacks E.g. cheetos";
        String result = transformer.transform(input);
        assertEquals("snacks For example cheetos", result);
        assertTrue(mockTransformer.isDone());
    }

}