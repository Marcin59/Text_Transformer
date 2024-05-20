package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.exceptions.IllegalTransformerNameException;
import pl.put.poznan.transformer.logic.textDecorators.NumbersToTextDecorator;
import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.WordsToAcronymsDecorator;
import pl.put.poznan.transformer.logic.textDecorators.AcronymsToWordsDecorator;
import pl.put.poznan.transformer.logic.textDecorators.LowerCaseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.UpperCaseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.CapitalizeDecorator;
import pl.put.poznan.transformer.logic.textDecorators.LatexDecorator;


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
                case "AcronymsToWords":
                    decoratedTransformer = new AcronymsToWordsDecorator(decoratedTransformer);
                    break;
                case "ToUpperCase":
                    decoratedTransformer = new UpperCaseDecorator(decoratedTransformer);
                    break;
                case "ToLowerCase":
                    decoratedTransformer = new LowerCaseDecorator(decoratedTransformer);
                    break;
                case "ToCapitalizeCase":
                    decoratedTransformer = new CapitalizeDecorator(decoratedTransformer);
                    break;
                case "Latex":
                    decoratedTransformer = new LatexDecorator(decoratedTransformer);
                    break;
                default: throw new IllegalTransformerNameException(transform);
            }
        }
    }

    public String transform(String text){
        return decoratedTransformer.transform(text);
    }
}
