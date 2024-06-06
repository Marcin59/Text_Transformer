package pl.put.poznan.transformer.logic.textDecorators;

import pl.put.poznan.transformer.logic.TextTransformer;

class MockTransformer implements TextTransformer {
    private int calls_required;
    MockTransformer(int calls_required) {
        this.calls_required = calls_required;
    }
    @Override
    public String transform(String text) {
        calls_required--;
        return text;
    }

    public boolean isDone() {
        return calls_required == 0;
    }
}
