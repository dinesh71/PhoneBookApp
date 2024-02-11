package com.phonebooking.phonebooking.model;

import java.time.LocalDateTime;

public class Phone {

    private Long id;

    private String modal;
    private boolean available;
    private String bookedBy;
    private LocalDateTime localDateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", modal='" + modal + '\'' +
                ", available=" + available +
                ", bookedBy='" + bookedBy + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}