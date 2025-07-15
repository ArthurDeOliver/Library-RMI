package com.sd.project.common.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Reservation implements Serializable {
    private int id;
    private LocalDate reservationDate;
    private int userId;
    private String bookIsbn;
    private LocalDate finalReservationDate;
    private Boolean StatusReservation;

    public Reservation(int userId, String bookIsbn) {
        this.id = 0;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.reservationDate = LocalDate.now();
        this.StatusReservation = true; 
        this.finalReservationDate = this.reservationDate.plusDays(7); 
        
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Boolean getStatusReservation() {
        return StatusReservation;
    }

    public void setStatusReservation(Boolean statusReservation) {
        this.StatusReservation = statusReservation;
    }

    public ChronoLocalDate getFinalReservationDate() {
        return finalReservationDate;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reserva " + id + ":" + "Livro " + bookIsbn +  "(" + "Usuario " + userId + ")" + " - " + (StatusReservation ? "Ativa" : "Finalizada");
    }
}