package bai_tap_them.quan_ly_phuong_tien.model;

import java.time.LocalDate;

public class Car extends Vehicle {
    private Integer seat;
    private String type;

    public Car() {
    }

    public Car(String license, String production, LocalDate year, String owner, Integer seat, String type) {
        super(license, production, year, owner);
        this.seat = seat;
        this.type = type;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", seat: " + seat +
                ", type: " + type;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",
                super.getLicense(),
                super.getProduction(),
                super.getYear(),
                super.getOwner(),
                this.getSeat(),
                this.getType());
    }
}
