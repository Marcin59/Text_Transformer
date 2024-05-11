package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers2TextDecorator extends TextDecorator {
    public Numbers2TextDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }


    private String number2text(String number) {
        String[] single_digits = new String[]{"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] double_digits = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String temp = "";
        int n = number.length();
        if (n == 1) {
            temp = single_digits[number.charAt(0) - '0'];
        } else if (n == 2) {
            if (number.charAt(0) == '1') {
                temp = teens[number.charAt(1) - '0'];
            } else {
                temp = double_digits[number.charAt(0) - '2'];
                if (number.charAt(1) != '0') {
                    temp += "-" + single_digits[number.charAt(1) - '0'];
                }
            }
        } else if (n == 3) {
            temp = single_digits[number.charAt(0) - '0'] + " hundred";
            if (number.charAt(1) != '0') {
                temp += " ";
                if (number.charAt(1) == '1') {
                    temp += teens[number.charAt(2) - '0'];
                } else {
                    temp += double_digits[number.charAt(1) - '2'];
                    if (number.charAt(2) != '0') {
                        temp += "-" + single_digits[number.charAt(2) - '0'];
                    }
                }
            } else if (number.charAt(2) != '0') {
                temp += " " + single_digits[number.charAt(2) - '0'];
            }

        } else if (number.equals("1000")) {
            temp = "one thousand";
        } else {
            temp = number;
        }
        return temp;
    }

    @Override
    public String transform(String text) {


        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        String number;


        while (matcher.find()) {

            number = matcher.group();
            String temp = null;

            if (number.contains(".")) {
                String whole = number.substring(0, number.indexOf('.'));
                String decimal = number.substring(number.indexOf('.') + 1);
                int len_float = decimal.length();
                if (len_float == 1 && !whole.equals(number2text(whole))) {
                    if (decimal.equals("0")) {
                        temp = number2text(whole);
                    } else {
                        temp = number2text(whole) + " and " + number2text(decimal) + " tenths";
                    }
                } else if (len_float == 2 && !whole.equals(number2text(whole))) {
                    if (decimal.equals("00")) {
                        temp = number2text(whole);
                    } else {
                        temp = number2text(whole) + " and " + number2text(decimal) + " hundredths";
                    }
                } else {
                    temp = number;
                }

            } else {
                temp = number2text(number);
            }

            matcher.appendReplacement(sb, temp);
        }


        matcher.appendTail(sb);


        return sb.toString();
    }

}
