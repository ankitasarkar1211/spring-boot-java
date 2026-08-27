package org.example.bookcrud.repository;

import org.example.bookcrud.entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bookRepository extends JpaRepository<book, Long> {

    List<book> findByAuthor(String author);

    List<book> findByGenre(String genre);
}
