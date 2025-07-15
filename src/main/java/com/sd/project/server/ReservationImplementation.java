package com.sd.project.common.server;

import com.sd.project.common.models.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationImplementation extends UnicastRemoteObject implements ReservationService {

    private final HashMap<Integer, Reservation> reservations = new HashMap<>();
    private int nextId = 1;

    public ReservationImplementation() throws RemoteException {
        super();
    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {
        reservation.setId(nextId++);
        reservations.put(reservation.getId(), reservation);
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
    public Void getStatusReservation(int id) throws RemoteException {
        Reservation reservation = reservations.get(id);
        if (reservation != null) {
            System.out.println("Status: " + reservation.getStatus());
        }
        return null;
    }

    @Override
    public void updateStatusReservation(Reservation reservation) throws RemoteException {
        Reservation existing = reservations.get(reservation.getId());
        if (existing != null) {
            existing.setStatus(reservation.getStatus());
        }
    }
}