package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static List<Product> productList = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);

    static {
        productList.add(new Product(1, "Revive", 15000, 24));
        productList.add(new Product(2, "Sting", 12000, 15));
        productList.add(new Product(3, "Number one", 20000, 15));
        productList.add(new Product(4, "Aquafina", 11000, 30));
        productList.add(new Product(5, "Cocacola", 14000, 30));
    }

    public static void main(String[] args) {
        Collections.sort(productList);
        do {
            System.out.println("----------Product Management----------");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Search product");
            System.out.println("6. Sort product");
            System.out.println("7. Exit");

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
                    System.out.println("----------Sort Product----------");
                    sortProduct();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Input choose incorrect.");
            }
        } while (true);
    }

    public static void displayProduct() {
        for (Product item : productList) {
            if (item != null) {
                System.out.println(item);
            }
        }
        System.out.println("List product: " + Product.count + " items.");
    }

    public static void addNewProduct() {
        System.out.println("Enter name product: ");
        String name = input.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(input.nextLine());

        productList.add(new Product(Product.count + 1, name, price, quantity));
        System.out.println("Add successful!");
    }

    public static void updateProduct() {
        System.out.println("Enter ID product want update: ");
        int idUpdate = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexProduct = 0;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == idUpdate) {
                check = true;
                indexProduct = i;
                break;
            }
        }

        if (check) {
            System.out.println("Enter new name product: ");
            String name = input.nextLine();
            System.out.println("Enter new price: ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println("Enter new quantity: ");
            int quantity = Integer.parseInt(input.nextLine());

            productList.get(indexProduct).setProductName(name);
            productList.get(indexProduct).setProductPrice(price);
            productList.get(indexProduct).setProductQuantity(quantity);

            System.out.println("Update OK");
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void deleteProduct() {
        System.out.println("Enter ID product want delete: ");
        int idDelete = Integer.parseInt(input.nextLine());
        boolean check = false;
        int indexProduct = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == idDelete) {
                check = true;
                indexProduct = i;
                break;
            }
        }

        if (check) {
            productList.remove(indexProduct);
            System.out.println("Delete OK.");
            Product.count -= 1;
        } else {
            System.out.println("This ID does not exist.");
        }
    }

    public static void searchProduct() {
        System.out.println("Enter name product want to search: ");
        String strSearch = input.nextLine();
        int countProductSearch = 0;
        for (Product product : productList) {
            if (product.getProductName().contains(strSearch)) {
                System.out.println(product);
                countProductSearch++;
            }
        }
        System.out.println("Result: " + countProductSearch + " items.");
    }

    public static void sortProduct() {
        System.out.println("Sort by: ");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        int choose = Integer.parseInt(input.nextLine());
        switch (choose) {
            case 1:
                productList.sort(new ProductNameComparator());
                displayProduct();
                break;
            case 2:
                productList.sort(new ProductPriceComparator());
                displayProduct();
                break;
            case 3:
                productList.sort(new ProductQuantityComparator());
                displayProduct();
                break;
            default:
                System.out.println("Choose incorrect");
        }
    }

}
