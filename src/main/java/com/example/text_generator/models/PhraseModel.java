package com.example.text_generator.models;

import jakarta.persistence.*;

@Entity
@Table(name = "phrases")
public class PhraseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phrase;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private  Long authorId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Long categoryId;


}
