package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_array_list.models;

public class Product implements Comparable<Product> {
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    public static int count = 0;

    public Product() {
    }

    public Product(int productID, String productName, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        count++;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.getProductID() > o.getProductID()) {
            return 1;
        } else if (this.getProductID() < o.getProductID()) {
            return -1;
        } else {
            return 1;
        }
    }
}
