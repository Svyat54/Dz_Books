package com.example.dz_books.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nameBook;
    private String author;
    private String year;
    private String style;
    private int countPage;
    private String description;

    public Books(String nameBook, String author, String year, String style, int countPage, String description) {
        this.nameBook = nameBook;
        this.author = author;
        this.year = year;
        this.style = style;
        this.countPage = countPage;
        this.description = description;
    }

    public Books() {
    }
}
