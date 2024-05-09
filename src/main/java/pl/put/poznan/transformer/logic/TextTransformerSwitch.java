package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;

import java.util.Objects;

public class TextTransformerSwitch {
    public TextTransformer decoratedTransformer;
    public TextTransformerSwitch(TextTransformer component, String[] transforms){
        decoratedTransformer = component;
        for(String transform: transforms){
            if(Objects.equals(transform, "Reverse")){
                decoratedTransformer = new ReverseDecorator(decoratedTransformer);
            }
        }
    }

    public String transform(String text){
        return decoratedTransformer.transform(text);
    }
}
