package com.sd.project.common.server;

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

    public void updateStatusBook(Book book) throws RemoteException {
        if(book.getStatusBook){
            book.setStatusBook(false);
        } else {
            book.setStatusBook(true);
        }
    }

    @Override
    public List<Book> getAllBooks() throws RemoteException {
        return new ArrayList<>(books.values());
    }

    @Override
    public void getBookStatus(String isbn) throws RemoteException {
        Book book = books.get(isbn);
        if (book != null) {
            System.out.println("Status of the book: " + book.getStatusBook());
        } else {
            System.out.println("Book not found.");
        }
    }
}
