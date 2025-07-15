package com.sd.project.common.models;

import java.io.Serializable;

public class Reservation implements Serializable {
    private int id;
    private String reservationDate;
    private String userId;
    private String bookIsbn;
    private String finalReservationDate;
    private Bool StatusReservation;

    public Reservation(int id, String userId, String bookIsbn, String reservationDate) {
        this.id = id;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.reservationDate = reservationDate;
        this.StatusReservation = false; // Default status is false (not reserved)
        this.finalReservationDate = null; // Default final reservation date is null
        
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