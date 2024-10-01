package com.example.demo.Service1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @GetMapping
    public ResponseEntity<String> translate(@RequestParam String text) {
        String translatedText = translationService.translate(text);
        return ResponseEntity.ok(translatedText);
    }
}
