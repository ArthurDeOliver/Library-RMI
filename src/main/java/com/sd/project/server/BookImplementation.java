package com.sd.project.common.services;

import com.sd.project.common.models.Book;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

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

    @Override
    public List<Book> getAllBooks() throws RemoteException {
        return new ArrayList<>(books.values());
    }
}
