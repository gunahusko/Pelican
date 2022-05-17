package io.gunahusko.pelican.models;

public class TranslationResponse {

    private String translation;

    public TranslationResponse(String translation) {
        this.translation = translation;
    }

    public TranslationResponse() {
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
