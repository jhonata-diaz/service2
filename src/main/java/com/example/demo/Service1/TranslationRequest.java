package com.example.demo.Service1;


public class TranslationRequest {
    private String text;

    public TranslationRequest() {
    }

    public TranslationRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

