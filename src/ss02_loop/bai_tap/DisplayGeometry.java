package ss02_loop.bai_tap;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Input width: ");
                    int width = input.nextInt();
                    System.out.println("Input height: ");
                    int height = input.nextInt();
                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= height; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle");
                    System.out.println("Input height: ");
                    int heightTriangle = input.nextInt();
                    System.out.println("Triangle bottom-left:");
                    for (int i = 1; i <= heightTriangle; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Triangle top-left:");
                    for (int i = heightTriangle; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Triangle bottom-right:");
                    for (int i = 1; i <= heightTriangle; i++) {
                        for (int k = heightTriangle; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Triangle top-right:");
                    for (int i = 1; i <= heightTriangle; i++) {
                        for (int j = heightTriangle; j >= i; j--) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                        for (int k = 1; k <= i; k++) {
                            System.out.print(" ");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    System.out.println("Input height: ");
                    int heightIsoscelesTriangle = input.nextInt();
                    for (int i = 1; i <= heightIsoscelesTriangle; i++) {
                        for (int k = heightIsoscelesTriangle; k > i; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" *");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
