package com.sd.project.common.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.sd.project.common.models.Book;

public interface BookService extends Remote {
    void addBook(Book book) throws RemoteException;
    Book getBook(String isbn) throws RemoteException;
    List<Book> getAllBooks() throws RemoteException;
    void updateStatusBook(Book book) throws RemoteException;
    Boolean getBookStatus(String isbn) throws RemoteException;
}