package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformerSwitchTest {
    @Test
    public void testReversing(){
        TextTransformerSwitch transformerSwitch = new TextTransformerSwitch(new BaseTextTransformer(), new String[]{"Reverse"});
        assertEquals("abcD", transformerSwitch.transform("dcbA"));
    }

    @Test
    public void testTransformerNameException(){
        assertThrows(IllegalArgumentException.class, () -> {
            TextTransformerSwitch transformerSwitch = new TextTransformerSwitch(new BaseTextTransformer(), new String[]{"WrongName"});
        });
    }
}