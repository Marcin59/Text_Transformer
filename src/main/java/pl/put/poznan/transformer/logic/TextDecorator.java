package pl.put.poznan.transformer.logic;

public class TextDecorator implements TextTransformer{
    protected final TextTransformer textToTransform;

    public TextDecorator(TextTransformer textToTransform){
        this.textToTransform = textToTransform;
    }
    @Override
    public String transform(String text){
        return textToTransform.transform(text);
    }
}
