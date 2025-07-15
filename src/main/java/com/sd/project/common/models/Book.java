package com.sd.project.common.models;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private Bool StatusBook;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn, Bool StatusBook) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.StatusBook = false;
    }

    public String getTitle() {
        return title;
    }
    public void setStatusBook(Bool statusBook) {
        this.StatusBook = statusBook;
    }
    
    public Bool getStatusBook() {
        return StatusBook;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + " (" + author + ")";
    }
}