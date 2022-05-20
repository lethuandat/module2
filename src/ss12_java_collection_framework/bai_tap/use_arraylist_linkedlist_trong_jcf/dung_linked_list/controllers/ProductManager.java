package ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_linked_list.controllers;

import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_linked_list.services.IProductServices;
import ss12_java_collection_framework.bai_tap.use_arraylist_linkedlist_trong_jcf.dung_linked_list.services.ProductServicesImpl;

import java.util.Scanner;

public class ProductManager {
    public static Scanner input = new Scanner(System.in);
    static IProductServices productServices = new ProductServicesImpl();

    public static void listActionLinkedList() {
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
                    productServices.displayProduct();
                    break;
                case 2:
                    System.out.println("----------Add New Product----------");
                    productServices.addNewProduct();
                    break;
                case 3:
                    System.out.println("----------Update Product----------");
                    productServices.updateProduct();
                    break;
                case 4:
                    System.out.println("----------Delete Product----------");
                    productServices.deleteProduct();
                    break;
                case 5:
                    System.out.println("----------Search Product----------");
                    productServices.searchProduct();
                    break;
                case 6:
                    System.out.println("----------Sort Product----------");
                    productServices.sortProduct();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Input choose incorrect.");
            }
        } while (true);
    }

}
