package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words2AcronymsDecorator extends TextDecorator {
    public Words2AcronymsDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    private String words2acronym(String words) {
        if (Character.isUpperCase(words.charAt(0))){
            words=words.toLowerCase();
            switch (words) {
                case "for example":
                    return "E.g.";
                case "among others":
                    return "I.a.";
                case "and so on":
                    return "Aso";
                default:
                    return words;
            }
        }
        words=words.toLowerCase();
        switch (words) {
            case "for example":
                return "e.g.";
            case "among others":
                return "i.a.";
            case "and so on":
                return "aso";
            default:
                return words;
        }
    }

    @Override
    public String transform(String text) {
        String[] expressions = {"for example", "among others", "and so on"};
        for (String expression : expressions) {
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String match = matcher.group();
                text = text.replace(match, words2acronym(match));
            }
        }
        return text;
    }

}
