package pl.put.poznan.transformer.logic;

/**
 * The TextDecorator class is an implementation of the TextTransformer interface.
 * It decorates the text transformation functionality provided by another TextTransformer object.
 */
public class TextDecorator implements TextTransformer{
    protected final TextTransformer textToTransform;

    /**
     * Constructs a TextDecorator object with the specified TextTransformer object.
     * @param textToTransform The TextTransformer object to decorate.
     */
    public TextDecorator(TextTransformer textToTransform){
        this.textToTransform = textToTransform;
    }

    /**
     * Transforms the given text by delegating the transformation to the decorated TextTransformer object.
     * @param text The text to transform.
     * @return The transformed text.
     */
    @Override
    public String transform(String text){
        return textToTransform.transform(text);
    }
}
