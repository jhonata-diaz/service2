package com.example.demo.Service1;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslationService {

    private Map<String, String> translations;

    public TranslationService() {
        // Inicializamos algunas traducciones
        translations = new HashMap<>();
        translations.put("hello", "hola");
        translations.put("world", "mundo");
        translations.put("goodbye", "adiós");
        translations.put("thank you", "gracias");
    }

    public String translate(String text) {
        // Retorna la traducción si existe, o el texto original si no se encuentra
        return translations.getOrDefault(text.toLowerCase(), text);
    }
}

