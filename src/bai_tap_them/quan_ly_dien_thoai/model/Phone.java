package bai_tap_them.quan_ly_dien_thoai.model;

public abstract class Phone {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private String production;

    public Phone() {
    }

    public Phone(Integer id, String name, Double price, Integer quantity, String production) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.production = production;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", name: " + name +
                ", price: " + price +
                ", quantity: " + quantity +
                ", production: " + production;
    }

    public abstract String getInfo();
}
