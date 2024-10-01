package com.example.demo.Service1;


import com.example.demo.Service1.TranslationController;
import com.example.demo.Service1.TranslationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TranslationControllerTest {

    @InjectMocks
    private TranslationController translationController;

    @Mock
    private TranslationService translationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTranslate_ExistingWord_ReturnsTranslation() {
        // Dado
        String text = "hello";
        String expectedTranslation = "hola";
        when(translationService.translate(text)).thenReturn(expectedTranslation);

        // Cuando
        ResponseEntity<String> response = translationController.translate(text);

        // Entonces
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedTranslation, response.getBody());
    }

    @Test
    void testTranslate_NonExistingWord_ReturnsOriginalText() {
        // Dado
        String text = "unknown";
        when(translationService.translate(text)).thenReturn(text);

        // Cuando
        ResponseEntity<String> response = translationController.translate(text);

        // Entonces
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(text, response.getBody());
    }
}
