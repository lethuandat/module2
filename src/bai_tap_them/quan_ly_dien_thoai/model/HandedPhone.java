package bai_tap_them.quan_ly_dien_thoai.model;

import bai_tap_them.quan_ly_dien_thoai.comma.Comma;

public class HandedPhone extends Phone {
    private String country;
    private String status;

    public HandedPhone() {
    }

    public HandedPhone(Integer id, String name, Double price, Integer quantity, String production, String country, String status) {
        super(id, name, price, quantity, production);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", country: " + country +
                ", status: " + status;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getPrice() + Comma.COMMA +
                super.getQuantity() + Comma.COMMA +
                super.getProduction() + Comma.COMMA +
                this.getCountry() + Comma.COMMA +
                this.getStatus() + "\n";
    }
}
