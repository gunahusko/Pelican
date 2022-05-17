package io.gunahusko.pelican.models;

public class PelicanResponse {

    private String data;

    public PelicanResponse(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
