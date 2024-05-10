package pl.put.poznan.transformer.logic.textTransformers;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;

import java.util.Objects;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BaseTextTransformer implements TextTransformer {
    @Override
    public String transform(String text){
        return text;
    }
}