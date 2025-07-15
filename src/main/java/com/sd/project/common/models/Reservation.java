package com.sd.project.common.models;

import java.io.Serializable;

public class Reservation implements Serializable {
    private int id;
    private String reservationDate;
    private String userId;
    private String bookIsbn;

    public Reservation(int id, String userId, String bookIsbn, String reservationDate) {
        this.id = id;
        this.userId = userId;
        this.bookIsbn = bookIsbn;
        this.reservationDate = reservationDate;
    }

    public String getUserId() {
        return userId;
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