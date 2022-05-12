package bai_tap_them;

import java.util.Scanner;

public class Main {
    public static Product[] products = new Product[6];
    public static Scanner input = new Scanner(System.in);


    static {
        products[0] = new Product(1, "Xiaomi Mi 7", "Xiaomi", 499, 2);
        products[1] = new Product(2, "LG G5", "LG", 599, 5);
        products[2] = new Product(3, "Iphone 11", "Apple", 699, 12);
        products[3] = new Product(4, "Samsung A53", "Samsung", 699, 12);
        products[4] = new Product(5, "Oppo X7", "Oppo", 699, 12);
    }

    public static void displayProduct() {
        for (Product item : products) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("List product: " + Product.count + " items.");
    }

    public static void addNewProduct() {
        if (Product.count >= products.length) {
            System.out.println("Full stock, can not add.");
        } else {
            System.out.println("Enter name product: ");
            String name = input.nextLine();
            System.out.println("Enter name producer: ");
            String producer = input.nextLine();
            System.out.println("Enter price: ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println("Enter quantity: ");
            int quantity = Integer.parseInt(input.nextLine());

            Product newProduct = new Product(Product.count + 1, name, producer, price, quantity);
            products[Product.count - 1] = newProduct;
        }

    }

    public static void updateProduct() {
        System.out.println("Enter ID product want update: ");
        int id = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexProduct = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                check = true;
                indexProduct = i;
                break;
            }
        }

        if (check) {
            System.out.println("Enter new name product: ");
            String name = input.nextLine();
            System.out.println("Enter new name producer: ");
            String producer = input.nextLine();
            System.out.println("Enter new price: ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println("Enter new quantity: ");
            int quantity = Integer.parseInt(input.nextLine());

            products[indexProduct].setName(name);
            products[indexProduct].setProducer(producer);
            products[indexProduct].setPrice(price);
            products[indexProduct].setQuantity(quantity);
        } else {
            System.out.println("This ID does not exist.");
        }

    }

    public static void deleteProduct() {
        System.out.println("Enter ID product want delete: ");
        int id = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexProduct = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                check = true;
                indexProduct = i;
                break;
            }
        }

        if (check) {
            products[indexProduct] = null;
            Product.count -= 1;
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void searchProduct() {
        System.out.println("Enter anything want to search: ");
        String strSearch = input.nextLine();
        int countProductSearch = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && (products[i].getName().contains(strSearch) || products[i].getProducer().contains(strSearch))) {
                System.out.println(products[i]);
                countProductSearch++;
            }
        }
        System.out.println("Result: " + countProductSearch + " items.");
    }

    public static void main(String[] args) {
        do {
            System.out.println("----------Product Management----------");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Search product");
            System.out.println("6. Exit");

            System.out.println("Choose option, please!\nChoose = ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("----------List Product----------");
                    displayProduct();
                    break;
                case 2:
                    System.out.println("----------Add New Product----------");
                    addNewProduct();
                    break;
                case 3:
                    System.out.println("----------Update Product----------");
                    updateProduct();
                    break;
                case 4:
                    System.out.println("----------Delete Product----------");
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("----------Search Product----------");
                    searchProduct();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

}
