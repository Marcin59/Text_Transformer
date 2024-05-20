package pl.put.poznan.transformer.logic;


import pl.put.poznan.transformer.logic.textDecorators.NumbersToTextDecorator;
import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.WordsToAcronymsDecorator;


import java.util.Objects;

public class TextTransformerSwitch {
    public TextTransformer decoratedTransformer;
    public TextTransformerSwitch(TextTransformer component, String[] transforms){
        decoratedTransformer = component;
        for(String transform: transforms){
            switch (transform){
                case "Reverse":
                    decoratedTransformer = new ReverseDecorator(decoratedTransformer);
                    break;
                case "NumbersToText":
                    decoratedTransformer = new NumbersToTextDecorator(decoratedTransformer);
                    break;
                case "WordsToAcronyms":
                    decoratedTransformer = new WordsToAcronymsDecorator(decoratedTransformer);
                    break;
                default: throw new IllegalArgumentException("Wrong transformer name");
            }
        }
    }

    public String transform(String text){
        return decoratedTransformer.transform(text);
    }
}
