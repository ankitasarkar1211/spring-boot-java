package org.example.bookcrud.service;

import org.example.bookcrud.entity.book;
import org.example.bookcrud.repository.bookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookService {

    private final bookRepository bookRepository;

    // Constructor Injection
    public bookService(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Book not found with id: " + id)
                );
    }

    // Create book
    public book createBook(book book) {
        return bookRepository.save(book);
    }

    // Update book
    public book updateBook(Long id, book updatedBook) {

        book book = getBookById(id);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());

        return bookRepository.save(book);
    }

    // Delete book
    public void deleteBook(Long id) {

        book book = getBookById(id);

        bookRepository.delete(book);
    }
}