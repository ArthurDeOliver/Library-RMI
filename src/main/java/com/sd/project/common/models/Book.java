package com.sd.project.common.models;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private Boolean StatusBook;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.StatusBook = false;
    }

    public String getTitle() {
        return title;
    }
    public void setStatusBook(Boolean statusBook) {
        this.StatusBook = statusBook;
    }
    
    public Boolean getStatusBook() {
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
        return title + " (" + author + ")" + " - " + (StatusBook ? "Emprestado" : "Disponível");
    }
}