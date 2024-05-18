package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.textDecorators.Numbers2TextDecorator;
import pl.put.poznan.transformer.logic.textDecorators.ReverseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.Words2AcronymsDecorator;
import pl.put.poznan.transformer.logic.textDecorators. AcronymsToWordsDecorator;
import pl.put.poznan.transformer.logic.textDecorators.LowerCaseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.UpperCaseDecorator;
import pl.put.poznan.transformer.logic.textDecorators.CapitalizeDecorator;



public class TextTransformerSwitch {
    public TextTransformer decoratedTransformer;
    public TextTransformerSwitch(TextTransformer component, String[] transforms){
        decoratedTransformer = component;
        for(String transform: transforms){
            switch (transform){
                case "Reverse":
                    decoratedTransformer = new ReverseDecorator(decoratedTransformer);
                    break;
                case "Numbers2Text":
                    decoratedTransformer = new Numbers2TextDecorator(decoratedTransformer);
                    break;
                case "Words2Acronyms":
                    decoratedTransformer = new Words2AcronymsDecorator(decoratedTransformer);
                    break;
                case "Acronyms2Words":
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

                default: throw new IllegalArgumentException("Wrong transformer name");
            }
        }
    }

    public String transform(String text){
        return decoratedTransformer.transform(text);
    }
}
