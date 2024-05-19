package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import static org.junit.jupiter.api.Assertions.*;

class LatexDecoratorTest {
    public static TextTransformer transformer;
    @BeforeAll
    static void setUp(){
        transformer = new LatexDecorator(new BaseTextTransformer());
    }

    @Test
    public void testEscapeCharacters(){
        String test="&%$#_{}";
        String answer="\\&\\%\\$\\#\\_\\{\\}";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testReplaceCharacters(){
        String test="\\^\\~";
        String answer="\\textbackslash\\textasciicircum\\textbackslash\\textasciitilde";
        assertEquals(answer, transformer.transform(test));
    }
}