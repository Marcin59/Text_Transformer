package pl.put.poznan.transformer.rest;

public class TransformRequest {
    private String text;
    private String[] transforms;

    // getters and setters
    public String getText() {
        return text;
    }

    public String[] getTransforms() {
        return transforms;
    }

}