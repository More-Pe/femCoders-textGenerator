package com.example.text_generator.controllers;

import com.example.text_generator.models.Phrase;
import com.example.text_generator.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public ResponseEntity <List<Phrase>> getAllPhrases() {
        List<Phrase> phrases = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(phrases, HttpStatus.OK);
    }

    @PostMapping("/phrase")
    public ResponseEntity <Phrase> addPhrase(@RequestBody Phrase newPhrase) {
        Phrase createdPhrase = phraseService.addPhrase(newPhrase);
        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);
    }

    @GetMapping("/phrase/{id}")
    public ResponseEntity<Phrase> getPhraseById(@PathVariable Long id) {
        Phrase phrase = phraseService.getPhraseById(id);
        if (phrase != null) {
            return new ResponseEntity<>(phrase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/phrase/{id}")
    public ResponseEntity<Phrase> updatePhrase(@PathVariable Long id, @RequestBody Phrase updatedPhrase) {
        Phrase phrase = phraseService.updatePhrase(id, updatedPhrase);
        if (phrase != null) {
            return new ResponseEntity<>(phrase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/phrase/{id}")
    public ResponseEntity<Void> deletePhrase(@PathVariable Long id) {
        phraseService.deletePhrase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
