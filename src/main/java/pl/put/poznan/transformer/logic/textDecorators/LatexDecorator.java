/**
 * This class extends TextDecorator and provides functionality to convert text into a LaTeX supported format.
 * It replaces special characters with their LaTeX equivalents.
 */
package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextDecorator;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LatexDecorator extends TextDecorator {

    /**
     * List of special characters that need to be escaped with a single backslash in LaTeX.
     */
    private static final List<Character> SPECIAL_CHARACTERS_SLASH = Arrays.asList('&', '%', '$', '#', '_', '{', '}');

    /**
     * Mapping of special characters to their LaTeX equivalents.
     */
    private static final HashMap<Character, String> SPECIAL_CHARACTERS_REPLACE = new HashMap<Character, String>() {{
        put('\\', "\\textbackslash");
        put('^', "\\textasciicircum");
        put('~', "\\textasciitilde");
    }};

    /**
     * Constructor for the LatexDecorator class.
     * @param textToTransform The TextTransformer object that this decorator wraps around.
     */
    public LatexDecorator(TextTransformer textToTransform) {
        super(textToTransform);
    }

    /**
     * Transforms the input text by applying previous transformations and replacing special characters with their LaTeX equivalents.
     * @param text The input text to be transformed.
     * @return The transformed text.
     */
    @Override
    public String transform(String text){
        text = super.transform(text);
        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (SPECIAL_CHARACTERS_SLASH.contains(c)) {
                sb.append('\\');
                sb.append(c);
            } else if (SPECIAL_CHARACTERS_REPLACE.containsKey(c)) {
                sb.append(SPECIAL_CHARACTERS_REPLACE.get(c));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}