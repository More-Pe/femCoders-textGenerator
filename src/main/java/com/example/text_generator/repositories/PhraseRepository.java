package com.example.text_generator.repositories;

import com.example.text_generator.models.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
