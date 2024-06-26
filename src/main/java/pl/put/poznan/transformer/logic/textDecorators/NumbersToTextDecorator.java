package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The NumbersToTextDecorator class is a text decorator that converts numbers in a given text to their textual representation.
 * It extends the TextDecorator class and implements the TextTransformer interface.
 */
public class NumbersToTextDecorator extends TextDecorator {

    /**
     * Constructs a NumbersToTextDecorator object with the specified TextTransformer to decorate.
     *
     * @param textToTransform The TextTransformer object to decorate.
     */
    public NumbersToTextDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Converts a number to its textual representation.
     *
     * @param number The number to convert.
     * @return The textual representation of the number.
     */
    private String number2text(String number) {
        String[] single_digits = new String[]{"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] double_digits = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int n = number.length();
        String rest=null;
        if (n>1){
            number=number.replaceAll("^0+","");
        }
        n=number.length();
        switch (n){
            case 0:
                return "";
            case 1:
                return single_digits[number.charAt(0) - '0'];
            case 2:
                if (number.charAt(0)=='1'){
                    return teens[number.charAt(1) - '0'];
                } else if(number.charAt(1)=='0'){
                    return double_digits[number.charAt(0) - '2'];
                }
                else{
                    return double_digits[number.charAt(0) - '2'] + "-" + single_digits[number.charAt(1) - '0'];
                }
            case 3:
                rest=number.substring(1);
                if (rest.equals("00")){
                    return single_digits[number.charAt(0) - '0'] + " hundred";
                }
                else if(number.charAt(0)=='0'){
                    return number2text(rest);
                }
                return single_digits[number.charAt(0) - '0'] + " hundred " + number2text(rest);
            default:
                if (n<=6){
                    rest=number.substring(n-3);
                    if (rest.equals("000")){
                        return number2text(number.substring(0, n-3)) + " thousand";
                    }
                    return number2text(number.substring(0, n-3)) + " thousand " + number2text(rest);
                } else if (n<=9) {
                    rest=number.substring(n-6);
                    if (rest.equals("000000")){
                        return number2text(number.substring(0, n-6)) + " million";
                    }
                    return number2text(number.substring(0, n-6)) + " million " + number2text(rest);
                }
                else if (number.equals("1000000000")){
                    return "one billion";
                }
                else{
                    return number;
                }
        }

    }

    /**
     * Converts a decimal number to its textual representation.
     *
     * @param number The decimal number to convert.
     * @return The textual representation of the decimal number.
     */
    private String convert(String number) {
        String whole = number;
        String decimal = "";

        // Split the number into whole and decimal parts
        if (number.contains(".")) {
            whole = number.substring(0, number.indexOf('.'));
            decimal = number.substring(number.indexOf('.') + 1);
        }

        int len_float = decimal.length();
        int len_whole=whole.length();
        if (len_whole>10 || len_float>4){
            return number;
        }

        decimal = decimal.replaceAll("0*$", "");
        len_float=decimal.length();
        switch(len_float){
            case 0:
                return number2text(whole);
            case 1:
                if (decimal.equals("0")) {
                    return number2text(whole);
                } else {
                    return number2text(whole) + " and " + number2text(decimal) + " tenths";
                }
            case 2:
                if(decimal.equals("00")){
                    return number2text(whole);
                } else {
                    return number2text(whole) + " and " + number2text(decimal) + " hundredths";
                }
            case 3:
                if(decimal.equals("000")){
                    return number2text(whole);
                } else {
                    return number2text(whole) + " and " + number2text(decimal) + " thousandths";
                }
            case 4:
                if(decimal.equals("0000")){
                    return number2text(whole);
                } else {
                    return number2text(whole) + " and " + number2text(decimal) + " ten-thousandths";
                }
            default:
                return number;
        }
    }

    /**
     * Transforms the given text by converting numbers to their textual representation.
     *
     * @param text The text to transform.
     * @return The transformed text with numbers converted to their textual representation.
     */
    @Override
    public String transform(String text){
        text = super.transform(text);
        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        String number;
        while (matcher.find()) {
            number = matcher.group();
            matcher.appendReplacement(sb, convert(number));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}
