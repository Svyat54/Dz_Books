package com.example.dz_books.controller;

import com.example.dz_books.entities.Books;
import com.example.dz_books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class BookController {
    //Task2
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Books> all(){
        return bookRepository.findAll();
    }
    //Task3
    @PostMapping(path = "/add")
    public String add(@RequestParam String nameBook, @RequestParam String author,
                      @RequestParam String year, @RequestParam String style,
                      @RequestParam int countPage, @RequestParam String description){
        bookRepository.save(new Books(nameBook, author, year, style, countPage, description));
        return "Saved";
    }
    //Task4
    @PostMapping(path = "/delete")
    public String delete(@RequestParam Integer id){
        bookRepository.deleteById(id);
        return "Delete id: " + id;
    }
    //Task5
    @PostMapping(path = "/update")
    public String update(@RequestParam Integer id, @RequestParam(required = false) String nameBook,
                         @RequestParam(required = false) String author, @RequestParam(required = false) String year,
                         @RequestParam(required = false) String style, @RequestParam(required = false) int countPage,
                         @RequestParam(required = false) String description){
        Books books = bookRepository.findById(id).get();
        if(nameBook != null)
            books.setNameBook(nameBook);
        if(author != null)
            books.setAuthor(author);
        if(year != null)
            books.setYear(year);
        if(style != null)
            books.setStyle(style);
        if(countPage != 0)
            books.setCountPage(countPage);
        if(description != null)
            books.setDescription(description);
        bookRepository.save(books);
        return "Update id: " + id;
    }
    //Task6
    @PostMapping(path = "/findByName")
    public Iterable<Books> findByName(@RequestParam String nameBook){
        return bookRepository.findBooksByNameBookContainingIgnoreCase(nameBook);
    }
    @PostMapping(path = "/findByAuthor")
    public Iterable<Books> findByAuthor(@RequestParam String author){
        return bookRepository.findBooksByAuthorContainingIgnoreCase(author);
    }
    @PostMapping(path = "/findByYear")
    public Iterable<Books> findByYear(@RequestParam String year){
        return bookRepository.findBooksByYearContaining(year);
    }
    @PostMapping(path = "/findByStyle")
    public Iterable<Books> findByStyle(@RequestParam String style){
        return bookRepository.findBooksByStyleContainingIgnoreCase(style);
    }
    @PostMapping(path = "/findByCountPage")
    public Iterable<Books> findByCountPage(@RequestParam int countPageLow, @RequestParam int countPageHigh){
        return bookRepository.findBooksByCountPageBetween(countPageLow, countPageHigh);
    }
    @PostMapping(path = "/findByDescription")
    public Iterable<Books> findByDescription(@RequestParam String description){
        return bookRepository.findBooksByDescriptionContainingIgnoreCase(description);
    }


}
