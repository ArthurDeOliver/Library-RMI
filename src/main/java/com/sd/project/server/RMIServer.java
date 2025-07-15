package com.sd.project.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/UserService", new UserImplementation());
            Naming.rebind("rmi://localhost/BookService", new BookImplementation());
            Naming.rebind("rmi://localhost/ReservationService", new ReservationImplementation());
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

