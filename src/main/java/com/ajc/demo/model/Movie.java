package com.ajc.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Movie implements Serializable {
//    private static final AtomicInteger count = new AtomicInteger(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double duration;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate localDate;

    public Movie() {
    }

    public Movie(String title, double duration, LocalDate localDate) {
//        this.id = count.incrementAndGet();
        this.title = title;
        this.duration = duration;
        this.localDate = localDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
