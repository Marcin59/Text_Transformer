package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LowerCaseDecoratorTest {
    TextTransformer transformer;
    private MockTransformer mockTransformer;
    @BeforeEach
    public void setUp() {
        mockTransformer = new MockTransformer(1);
        transformer = new LowerCaseDecorator(mockTransformer);
    }

    @Test
    public void transform_AllUpperCaseText_AllLowerCase() {
        String input = "HELLO WORLD";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void transform_MixedCaseText_AllUpperCase() {
        String input = "HeLLo WoRLd";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
        assertTrue(mockTransformer.isDone());
    }

    @Test
    public void transform_AllLowerCaseText_Unchanged() {

        String input = "hello world";
        String result = transformer.transform(input);
        assertEquals("hello world", result);
        assertTrue(mockTransformer.isDone());
    }


}
