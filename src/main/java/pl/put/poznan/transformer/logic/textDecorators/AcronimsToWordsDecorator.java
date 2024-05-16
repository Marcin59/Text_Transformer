package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;
import java.util.HashMap;
import java.util.Map;

public class AcronimsToWordsDecorator extends TextDecorator {
    public AcronimsToWordsDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }
    private static final Map<String, String> abbreviationMap = new HashMap<>();

    static {
        abbreviationMap.put("prof.", "professor");
        abbreviationMap.put("dr", "doctor");
        abbreviationMap.put("e.g.", "for example");
        abbreviationMap.put("aso", "and so on");
    }
    public String transform(String text) {
        text = super.transform(text);
        return expandAbbreviations(text);
    }

    private static String expandAbbreviations(String input) {
        StringBuilder output = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c) || c == '.') {
                word.append(c);
            } else {
                String abbreviation = word.toString().toLowerCase();
                if (abbreviationMap.containsKey(abbreviation)) {
                    output.append(abbreviationMap.get(abbreviation));
                } else {
                    output.append(word);
                }
                output.append(c);
                word.setLength(0);
            }
        }

        if (word.length() > 0) {
            String abbreviation = word.toString().toLowerCase();
            if (abbreviationMap.containsKey(abbreviation)) {
                output.append(abbreviationMap.get(abbreviation));
            } else {
                output.append(word);
            }
        }

        return output.toString();
    }
}
