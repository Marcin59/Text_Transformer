package pl.put.poznan.transformer.logic.exceptions;

public class IllegalTransformerNameException extends IllegalArgumentException{
    public IllegalTransformerNameException(String transformName){
        super("Illegal transformer name: " + transformName);
    }
}
