package com.sd.project.server;

import com.sd.project.common.models.Book;
import com.sd.project.common.models.Reservation;
import com.sd.project.common.services.BookService;
import com.sd.project.common.services.ReservationService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

public class ReservationImplementation extends UnicastRemoteObject implements ReservationService {

    private final HashMap<Integer, Reservation> reservations = new HashMap<>();
    private final BookService bookService;
    private int nextId = 1;

    public ReservationImplementation(BookService bookService) throws RemoteException {
        super();
        this.bookService = bookService;

    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {
        reservation.setId(nextId++);
        reservations.put(reservation.getId(), reservation);

        Book book = bookService.getBook(reservation.getBookIsbn());
        if (book != null) {
            book.setStatusBook(true);
            bookService.updateStatusBook(book);
        }
    }

    @Override
    public Reservation getReservation(int id) throws RemoteException {
        return reservations.get(id);
    }

    @Override
    public List<Reservation> getAllReservations() throws RemoteException {
        return new ArrayList<>(reservations.values());
    }

    @Override
    public Boolean getStatusReservation(int id) throws RemoteException {
        Reservation reservation = reservations.get(id);
        Boolean status = true;
        if (reservation != null) {
            status = reservation.getStatusReservation();
        }
        return status;
    }

    @Override
    public void updateStatusReservation(Reservation reservation) throws RemoteException {
        Reservation existing = reservations.get(reservation.getId());
        if (existing != null) {
            Boolean currentStatus = existing.getStatusReservation();
            existing.setStatusReservation(!currentStatus);
        }
    }

    @Override
    public boolean isBookReserved(String isbn) throws RemoteException {
        LocalDate today = LocalDate.now();
        for (Reservation r : reservations.values()) {
            if (r.getBookIsbn().equals(isbn) && r.getStatusReservation() && today.isBefore(r.getFinalReservationDate())) {
                return true;
            }
        }
        return false;
    }

    @Override
        public void checkAndFinalizeReservations() throws RemoteException {
            LocalDate today = LocalDate.now();
            for (Reservation r : reservations.values()) {
                if (r.getStatusReservation() && today.isAfter(r.getFinalReservationDate())) {
                    r.setStatusReservation(false);
                    System.out.println("Reserva " + r.getId() + " finalizada automaticamente.");
                }
            }
        }
}