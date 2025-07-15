package com.sd.project.common.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

import com.sd.project.common.models.Reservation;

public interface ReservationService extends Remote {
    void addReservation(Reservation reservation) throws RemoteException;
    Reservation getReservation(int id) throws RemoteException;
    List<Reservation> getAllReservations() throws RemoteException;
    Boolean getStatusReservation(int id) throws RemoteException;  
    void updateStatusReservation(Reservation reservation) throws RemoteException;
    boolean isBookReserved(String isbn) throws RemoteException;
    void checkAndFinalizeReservations() throws RemoteException;
}