package bai_tap_them.quan_ly_nhan_vien_abc.model;

import bai_tap_them.quan_ly_nhan_vien_abc.comma.Comma;

import java.time.LocalDate;

public class ProduceEmployee extends Employee {
    private Integer quantity;
    private Double price;

    public ProduceEmployee() {
    }

    public ProduceEmployee(Integer id, String idEmployee, String name, LocalDate date, String address, Integer quantity, Double price) {
        super(id, idEmployee, name, date, address);
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", quantity: " + quantity +
                ", price: " + price;
    }

    @Override
    public String getInfo() {
        return super.getId() + Comma.COMMA +
                super.getIdEmployee() + Comma.COMMA +
                super.getName() + Comma.COMMA +
                super.getDate() + Comma.COMMA +
                super.getAddress() + Comma.COMMA +
                this.getQuantity() + Comma.COMMA +
                this.getPrice();
    }
}
