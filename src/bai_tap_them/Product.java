package bai_tap_them;

public class Product {
    private int id;
    private String name;
    private String producer;
    private double price;
    private int quantity;
    public static int count = 0;

    public Product() {
    }

    public Product(int id, String name, String producer, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.quantity = quantity;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = " + name +
                ", producer = " + producer +
                ", price = " + price +
                " USD, quantity = " + quantity +
                 " pcs}";
    }
}
