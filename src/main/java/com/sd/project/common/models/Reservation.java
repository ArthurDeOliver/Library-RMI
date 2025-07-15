package com.sd.project.common.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservation implements Serializable {
    private int id;
    private LocalDate reservationDate;
    private String userId;
    private String bookIsbn;
    private LocalDate finalReservationDate;
    private Bool StatusReservation;

    public Reservation(int id, String userId, String bookIsbn) {
        this.id = id;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.reservationDate = LocalDate.now();
        this.StatusReservation = true; 
        this.finalReservationDate = this.reservationDate.plusDays(7); 
        
    }

    public String getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public Bool getStatusReservation() {
        return StatusReservation;
    }

    public void setStatusReservation(Bool statusReservation) {
        this.StatusReservation = statusReservation;
    }

    public String getFinalReservationDate() {
        return finalReservationDate;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                "userId='" + userId + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                '}';
    }
}