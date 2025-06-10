package com.example.text_generator.controllers;

import com.example.text_generator.models.Author;
import com.example.text_generator.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController (AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping("/author")
    public ResponseEntity<Author> addAuthor(@RequestBody  Author newAuthor) {
        Author createdAuthor = authorService.addAuthor(newAuthor);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }
}
