package com.sd.project.server;

import com.sd.project.common.services.BookService;
import com.sd.project.common.services.ReservationService;
import com.sd.project.common.services.UserService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            UserService userService = new UserImplementation();
            BookService bookService = new BookImplementation();
            ReservationService reservationService = new ReservationImplementation(bookService);

            Naming.rebind("rmi://localhost/UserService", userService);
            Naming.rebind("rmi://localhost/BookService", bookService);
            Naming.rebind("rmi://localhost/ReservationService", reservationService);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

