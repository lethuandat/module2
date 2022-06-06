package bai_tap_them.quan_ly_rap_phim.model;

import bai_tap_them.quan_ly_rap_phim.comma.Comma;

import java.time.LocalDate;

public class Cinema {
    private String idCinema;
    private String name;
    private LocalDate day;
    private Integer quantity;

    public Cinema() {
    }

    public Cinema(String idCinema, String name, LocalDate day, Integer quantity) {
        this.idCinema = idCinema;
        this.name = name;
        this.day = day;
        this.quantity = quantity;
    }

    public String getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(String idCinema) {
        this.idCinema = idCinema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + idCinema +
                ", name: " + name +
                ", day: " + day +
                ", quantity: " + quantity;
    }

    public String getInfo() {
        return idCinema + Comma.COMMA +
                name + Comma.COMMA +
                day + Comma.COMMA +
                quantity;
    }
}
