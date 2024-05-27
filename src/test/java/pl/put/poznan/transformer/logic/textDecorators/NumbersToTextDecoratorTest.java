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
        String answer= "one smile, four and five tenths laughs, twenty-five and forty-six hundredths cries, one hundred fifty-eight and nine tenths tragedies, one thousand and seventy-eight hundredths screams. one thousand two hundred thirty-four and one thousand two hundred thirty-four ten-thousandths problems";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testHard(){
        String test="4nsw3r t0 7h1s 1 que5tion w177 be 127 w17h 56.7 errors pl.31se";
        String answer="4nsw3r t0 7h1s one que5tion w177 be one hundred twenty-seven w17h fifty-six and seven tenths errors pl.31se";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testBigNumbers(){
        String test="628273621 is a big number, same goes to 1000000000, 999999999, 4348291, 42091823, 500300200, 20202020";
        String answer="six hundred twenty-eight million two hundred seventy-three thousand six hundred twenty-one is a big number, same goes to one billion, nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine, four million three hundred forty-eight thousand two hundred ninety-one, forty-two million ninety-one thousand eight hundred twenty-three, five hundred million three hundred thousand two hundred, twenty million two hundred two thousand twenty";
        assertEquals(answer, transformer.transform(test));
    }

    @Test
    public void testMoreFloats(){
        String test="The number 4276192.3680 should be read same as 536872.2341 because i've extended functionality up to 999999999.9999";
        String answer= "The number four million two hundred seventy-six thousand one hundred ninety-two and three hundred sixty-eight thousandths should be read same as five hundred thirty-six thousand eight hundred seventy-two and two thousand three hundred forty-one ten-thousandths because i've extended functionality up to nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine and nine thousand nine hundred ninety-nine ten-thousandths";
        assertEquals(answer, transformer.transform(test));
    }

}