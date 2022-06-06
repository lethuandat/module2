package bai_tap_them.quan_ly_phuong_tien.model;

import java.time.LocalDate;

public class Truck extends Vehicle {
    private Double tonnage;

    public Truck() {
    }

    public Truck(String license, String production, LocalDate year, String owner, Double tonnage) {
        super(license, production, year, owner);
        this.tonnage = tonnage;
    }

    public Double getTonnage() {
        return tonnage;
    }

    public void setTonnage(Double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tonnage: " + tonnage;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s",
                super.getLicense(),
                super.getProduction(),
                super.getYear(),
                super.getOwner(),
                this.getTonnage());
    }
}
