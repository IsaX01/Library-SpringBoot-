package com.badiagroup.Library.controller;

import com.badiagroup.Library.model.books;
import com.badiagroup.Library.repository.books_repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/books")
public class books_controller {

    @Autowired
    private books_repository booksRepository;

    // Create (POST) a new book
    @PostMapping
    public ResponseEntity<books> createBook(@RequestBody books book) {
        books savedBook = booksRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Read (GET) all books
    @GetMapping
    public ResponseEntity<List<books>> getAllBooks() {
        List<books> books = booksRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Read (GET) a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<books> getBookById(@PathVariable Long id) {
        Optional<books> bookOptional = booksRepository.findById(id);
        if (bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    // Update (PUT) an existing book by ID
    @PutMapping("/{id}")
    public ResponseEntity<books> updateBook(@PathVariable Long id, @RequestBody books updatedBook) {
        Optional<books> existingBookOptional = booksRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            books existingBook = existingBookOptional.get();
            existingBook.setTitle(updatedBook.getTitle()); // Update specific fields
            existingBook.setAuthor(updatedBook.getAuthor());
            // Update other fields as needed
            books savedBook = booksRepository.save(existingBook);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        booksRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
