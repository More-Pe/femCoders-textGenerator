package com.example.text_generator.services;

import com.example.text_generator.models.Author;
import com.example.text_generator.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author addAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author author = getAuthorById(id);
        author.setName(updatedAuthor.getName());
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
