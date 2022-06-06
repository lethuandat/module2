package bai_tap_them.quan_ly_phuong_tien.model;

import java.time.LocalDate;

public abstract class Vehicle {
    private String license;
    private String production;
    private LocalDate year;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String license, String production, LocalDate year, String owner) {
        this.license = license;
        this.production = production;
        this.year = year;
        this.owner = owner;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "License: " + license +
                ", production: " + production +
                ", year: " + year +
                ", owner: " + owner;
    }

    public abstract String getInfo();
}
