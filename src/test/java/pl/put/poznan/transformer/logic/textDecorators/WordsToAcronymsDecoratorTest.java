package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import static org.junit.jupiter.api.Assertions.*;

class WordsToAcronymsDecoratorTest {

    public static TextTransformer transformer;

    @BeforeAll
    static void setUp(){
        transformer = new WordsToAcronymsDecorator(new BaseTextTransformer());
    }

    @Test
    public void testForExample(){
        String test="For example, this is a test, that tests FOR EXAMPLE how expression for example. gets changed to FOr ExaMPLe";
        String answer="E.g., this is a test, that tests E.g. how expression e.g.. gets changed to E.g.";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testAmongOthers(){
        String test="Among others, this is a test, that tests AMONG OTHERS how expression among others. gets changed to amONg otHErs";
        String answer="I.a., this is a test, that tests I.a. how expression i.a.. gets changed to i.a.";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testAndSoOn(){
        String test="And so on, this is a test, that tests AND SO ON how expression and so on. gets changed to AnD sO oN";
        String answer="Aso, this is a test, that tests Aso how expression aso. gets changed to Aso";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testAll(){
        String test="For example, lets test aMoNg OtheRs and SO ON so that we know that even foR examPLE works AMong others.";
        String answer="E.g., lets test i.a. aso so that we know that even e.g. works I.a..";
        assertEquals(answer, transformer.transform(test));
    }




}