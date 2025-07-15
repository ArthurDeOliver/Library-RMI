package com.sd.project.server;

import com.sd.project.common.models.Book;
import com.sd.project.common.services.BookService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookImplementation extends UnicastRemoteObject implements BookService {
    private HashMap<String, Book> books;

    public BookImplementation() throws RemoteException {
        books = new HashMap<>();
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        books.put(book.getIsbn(), book);
    }

    @Override
    public Book getBook(String isbn) throws RemoteException {
        return books.get(isbn);
    }

    public void updateStatusBook(Book book) throws RemoteException {
        Book existingBook = books.get(book.getIsbn());
        if (existingBook != null) {
            Boolean currentStatus = existingBook.getStatusBook();
            existingBook.setStatusBook(!currentStatus); 
        }
    }

    @Override
    public List<Book> getAllBooks() throws RemoteException {
        return new ArrayList<>(books.values());
    }

    @Override
    public Boolean getBookStatus(String isbn) throws RemoteException {
        Book book = books.get(isbn);
        Boolean status = true;
        if (book != null) {
            status = book.getStatusBook();
        } else {
            System.out.println("Book not found.");
        }

        return status;
    }
}
