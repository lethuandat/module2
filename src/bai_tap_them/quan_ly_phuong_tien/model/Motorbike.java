package bai_tap_them.quan_ly_phuong_tien.model;

import java.time.LocalDate;

public class Motorbike extends Vehicle {
    private Double wattage;

    public Motorbike() {
    }

    public Motorbike(String license, String production, LocalDate year, String owner, Double wattage) {
        super(license, production, year, owner);
        this.wattage = wattage;
    }

    public Double getWattage() {
        return wattage;
    }

    public void setWattage(Double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wattage: " + wattage;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s",
                super.getLicense(),
                super.getProduction(),
                super.getYear(),
                super.getOwner(),
                this.getWattage());
    }
}
