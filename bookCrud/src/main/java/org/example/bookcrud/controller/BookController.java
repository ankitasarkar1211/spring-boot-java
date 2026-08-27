package org.example.bookcrud.controller;

import org.example.bookcrud.entity.book;
import org.example.bookcrud.service.bookService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final bookService bookService;

    // Constructor Injection
    public BookController(bookService bookService) {
        this.bookService = bookService;
    }

    // GET all books
    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET book by ID
    @GetMapping("/{id}")
    public book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // POST create a new book
    @PostMapping
    public book createBook(@RequestBody book book) {
        return bookService.createBook(book);
    }

    // PUT update a book
    @PutMapping("/{id}")
    public book updateBook(
            @PathVariable Long id,
            @RequestBody book book
    ) {
        return bookService.updateBook(id, book);
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
}
