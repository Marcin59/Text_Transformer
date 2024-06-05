package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CapitalizeDecoratorTest {
    TextTransformer transformer;
    private MockTransformer mockTransformer;
    @BeforeEach
    public void setUp() {
        mockTransformer = new MockTransformer(1);
        transformer = new CapitalizeDecorator(mockTransformer);
    }

    @Test
    public void transform_AllLowerCaseText_CapitalizeCase() {
        String input = "hello world";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void transform_MixedCaseText_CapitalizeCase() {
        String input = "HeLLo WoRLd";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void transform_CapitalizeCaseText_Unchanged() {
        String input = "Hello World";
        String result = transformer.transform(input);
        assertEquals("Hello World", result);
        assertTrue(mockTransformer.isDone());
    }

}
