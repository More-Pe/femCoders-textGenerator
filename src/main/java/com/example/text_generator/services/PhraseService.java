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

    public Phrase getPhraseById(Long id) {
        return phraseRepository.findById(id).orElse(null);
    }

    public Phrase updatePhrase(Long id, Phrase updatedPhrase) {
        Phrase phrase = phraseRepository.findById(id).orElse(null);
        if (phrase == null) {
            return null;
        }
        if (updatedPhrase.getText() != null) {
            phrase.setText(updatedPhrase.getText());
        }
        if (updatedPhrase.getAuthor() != null) {
            phrase.setAuthor(updatedPhrase.getAuthor());
        }
        if (updatedPhrase.getCategory() != null) {
            phrase.setCategory(updatedPhrase.getCategory());
        }
        return phraseRepository.save(phrase);
    }

    public void deletePhrase(Long id) {
        phraseRepository.deleteById(id);
    }
}
