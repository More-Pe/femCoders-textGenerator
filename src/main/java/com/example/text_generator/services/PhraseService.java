package com.example.text_generator.services;

import com.example.text_generator.models.Phrase;
import com.example.text_generator.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository){
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases(){
        return phraseRepository.findAll();
    }

    public Phrase addPhrase(Phrase newPhrase) {
        return phraseRepository.save(newPhrase);
    }
    
}
