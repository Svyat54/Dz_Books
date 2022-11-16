package com.example.dz_books.repository;

import com.example.dz_books.entities.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Integer> {
    Iterable<Books> findBooksByNameBookContainingIgnoreCase(String nameBook);
    Iterable<Books> findBooksByAuthorContainingIgnoreCase(String author);
    Iterable<Books> findBooksByYearContaining(String year);
    Iterable<Books> findBooksByStyleContainingIgnoreCase(String style);
    Iterable<Books> findBooksByCountPageBetween(Integer countPageLow, Integer countPageHigh);
    Iterable<Books> findBooksByDescriptionContainingIgnoreCase(String description);
}
