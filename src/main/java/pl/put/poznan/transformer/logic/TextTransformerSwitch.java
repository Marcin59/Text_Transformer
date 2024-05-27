package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.exceptions.IllegalTransformerNameException;
import pl.put.poznan.transformer.logic.textDecorators.*;

/**
 * The TextTransformerSwitch class is responsible for applying a series of transformations to a given text.
 * It uses a decorator pattern to dynamically add functionality to the text transformer.
 */
public class TextTransformerSwitch {
    public TextTransformer decoratedTransformer;

    /**
     * Constructs a TextTransformerSwitch object with the specified component and transforms.
     * Each transform is applied to the component in the order they are provided.
     * @param component The initial text transformer component.
     * @param transforms An array of transform names to be applied.
     * @throws IllegalTransformerNameException if an invalid transform name is provided.
     */
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
                case "RemoveDuplicateWords":
                    decoratedTransformer = new RemoveDuplicateWordsDecorator(decoratedTransformer);
                case "ReverseCase":
                    decoratedTransformer = new ReverseCaseDecorator(decoratedTransformer);
                    break;
                default: throw new IllegalTransformerNameException(transform);
            }
        }
    }

    /**
     * Transforms the given text by applying all the registered transformations.
     * @param text The text to be transformed.
     * @return The transformed text.
     */
    public String transform(String text){
        return decoratedTransformer.transform(text);
    }
}
