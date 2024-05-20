package pl.put.poznan.transformer.logic.textDecorators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.textTransformers.BaseTextTransformer;

import static org.junit.jupiter.api.Assertions.*;

class NumbersToTextDecoratorTest {
    public static TextTransformer transformer;

    @BeforeAll
    static void setUp(){
        transformer = new NumbersToTextDecorator(new BaseTextTransformer());
    }
    @Test
    public void testPunctuation(){
        String test="I have 4! What 4? 4. Still don't know what 4, because you don't say!";
        String answer="I have four! What four? four. Still don't know what four, because you don't say!";
        assertEquals(answer, transformer.transform(test));

        test="I have 4.2! What 4.2? 4.2. Still don't know what 4.2, because you don't say!";
        answer="I have four and two tenths! What four and two tenths? four and two tenths. Still don't know what four and two tenths, because you don't say!";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testIntegers(){
        String test="0 apples, 5 bananas, 12 grapes, 57 oranges, 127 strawberries, 1000 kiwis, 1234 pineapples";
        String answer="zero apples, five bananas, twelve grapes, fifty-seven oranges, one hundred twenty-seven strawberries, one thousand kiwis, one thousand two hundred thirty-four pineapples";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testFloats(){
        String test="1.0 smile, 4.5 laughs, 25.46 cries, 158.9 tragedies, 1000.78 screams. 1234.1234 problems";
        String answer="one smile, four and five tenths laughs, twenty-five and forty-six hundredths cries, one hundred fifty-eight and nine tenths tragedies, one thousand and seventy-eight hundredths screams. 1234.1234 problems";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testHard(){
        String test="4nsw3r t0 7h1s 1 que5tion w177 be 127 w17h 56.7 errors pl.31se";
        String answer="4nsw3r t0 7h1s one que5tion w177 be one hundred twenty-seven w17h fifty-six and seven tenths errors pl.31se";
        assertEquals(answer, transformer.transform(test));
    }

}