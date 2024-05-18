package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;
import java.util.HashMap;
import java.util.Map;

public class AcronymsToWordsDecorator extends TextDecorator {
    public AcronymsToWordsDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    private static final Map<String, String> abbreviationMap = new HashMap<>();

    static {
        abbreviationMap.put("prof.", "professor");
        abbreviationMap.put("dr", "doctor");
        abbreviationMap.put("dr.", "doctor");
        abbreviationMap.put("e.g.", "for example");
        abbreviationMap.put("aso", "and so on");
        abbreviationMap.put("aso.", "and so on.");
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
                appendExpandedWord(output, word);
                output.append(c);
                word.setLength(0);
            }
        }

        if (word.length() > 0) {
            appendExpandedWord(output, word);
        }

        return output.toString();
    }

    private static void appendExpandedWord(StringBuilder output, StringBuilder word) {
        if (word.length() == 0) return;

        String originalWord = word.toString();
        String abbreviation = originalWord.toLowerCase();

        if (abbreviationMap.containsKey(abbreviation)) {
            String expanded = abbreviationMap.get(abbreviation);
            for (int i = 0; i < originalWord.length(); i++) {
                char originalChar = originalWord.charAt(i);
                char expandedChar = (i < expanded.length()) ? expanded.charAt(i) : expanded.charAt(expanded.length() - 1);

                if (Character.isUpperCase(originalChar)) {
                    output.append(Character.toUpperCase(expandedChar));
                } else {
                    output.append(expandedChar);
                }
            }
            // Append any remaining characters from the expanded string
            if (originalWord.length() < expanded.length()) {
                output.append(expanded.substring(originalWord.length()));
            }
        } else {
            output.append(originalWord);
        }
    }
}
