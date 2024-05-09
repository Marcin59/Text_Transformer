package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import static org.junit.jupiter.api.Assertions.*;
class ReverseDecoratorTest {
    public static TextTransformer transformer;
    @BeforeAll
    static void setUp(){
        transformer = new ReverseDecorator(new BaseTextTransformer());
    }
    @Test
    public void testReversing(){
        assertEquals("abcd", transformer.transform("dcba"));
    }
    @Test
    public void testCaseSensitivity(){
        assertEquals("aaAA", transformer.transform("aaAA"));
    }
    @Test
    public void testReverseDecorator(){
        assertEquals("aaBB", transformer.transform("bbAA"));
    }
}