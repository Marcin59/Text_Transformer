package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers2TextDecorator extends TextDecorator {
    public Numbers2TextDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }
    
//    public static void main(String[] args){
//        String test_text="I have 1 apple, 15 watermelons, 27 bananas, 100 pears, 257 oranges, 985 grapes and 1000 issues";
//        TextTransformer decoratedTransformer = null;
//        decoratedTransformer= new Numbers2TextDecorator(decoratedTransformer);
//        System.out.println(test_text);
//        System.out.println(decoratedTransformer.transform(test_text));
//    }

    @Override
    public String transform(String text){
        String [] single_digits = new String[] { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};
        String [] teens= new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] double_digits= new String[] { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuffer sb = new StringBuffer();
        String number;


        while (matcher.find()) {

            number = matcher.group();
            int n = number.length();
            String temp = "";
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
            } else if( n == 3){
                temp = single_digits[number.charAt(0) - '0'] + " hundred";
                if (number.charAt(1) != '0') {
                    temp += " ";
                    if (number.charAt(1) == '1') {
                        temp += teens[Integer.parseInt(number.substring(2)) - 10];
                    } else {
                        temp += double_digits[number.charAt(1) - '2'];
                        if (number.charAt(2) != '0') {
                            temp += "-" + single_digits[number.charAt(2) - '0'];
                        }
                    }
                }
                else if (number.charAt(2) != '0') {
                    temp += " " + single_digits[number.charAt(2) - '0'];
                }
                
            }
            else if (n == 4) {
                temp="one thousand";
            }
            else{
                temp="a lot";
            }

            matcher.appendReplacement(sb, temp);
        }


        matcher.appendTail(sb);


        return sb.toString();
    }

}
