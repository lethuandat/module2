package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String productName;
    private String production;
    private double price;

    public Product() {
    }

    public Product(int productID, String productName, String production, double price) {
        this.productID = productID;
        this.productName = productName;
        this.production = production;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", production='" + production + '\'' +
                ", price=" + price +
                '}';
    }
}
