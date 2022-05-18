package ss11_dsa_stack_queue.bai_tap.thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số muốn chuyển đổi: ");
        int numberDecimal = Integer.parseInt(input.nextLine());
        Stack<Integer> stack = new Stack<>();

        //Hệ 10 sang hệ nhị phân
        int numberBinary = numberDecimal;
        while (numberBinary > 0) {
            stack.push(numberBinary % 2);
            numberBinary /= 2;
        }
        String strBinary = "";
        while (!stack.isEmpty()) {
            strBinary += stack.pop();
        }

        //Hệ 10 sang hệ 16
        int numberHexadecimal = numberDecimal;
        while (numberHexadecimal > 0) {
            stack.push(numberHexadecimal % 16);
            numberHexadecimal /= 16;
        }
        String strHexadecimal = "";
        while (!stack.isEmpty()) {
            switch (stack.pop()) {
                case 0:
                    strHexadecimal += 0;
                    break;
                case 1:
                    strHexadecimal += 1;
                    break;
                case 2:
                    strHexadecimal += 2;
                    break;
                case 3:
                    strHexadecimal += 3;
                    break;
                case 4:
                    strHexadecimal += 4;
                    break;
                case 5:
                    strHexadecimal += 5;
                    break;
                case 6:
                    strHexadecimal += 6;
                    break;
                case 7:
                    strHexadecimal += 8;
                    break;
                case 8:
                    strHexadecimal += 8;
                    break;
                case 9:
                    strHexadecimal += 9;
                    break;
                case 10:
                    strHexadecimal += "A";
                    break;
                case 11:
                    strHexadecimal += "B";
                    break;
                case 12:
                    strHexadecimal += "C";
                    break;
                case 13:
                    strHexadecimal += "D";
                    break;
                case 14:
                    strHexadecimal += "E";
                    break;
                case 15:
                    strHexadecimal += "F";
                    break;
            }
        }

        //Hệ 10 sang hệ 8
        int numberOctal = numberDecimal;
        while (numberOctal > 0) {
            stack.push(numberOctal % 8);
            numberOctal /= 8;
        }
        String strOctal = "";
        while (!stack.isEmpty()) {
            strOctal += stack.pop();
        }


        System.out.println(numberDecimal + " chuyển sang hệ nhị phân là: " + strBinary);
        System.out.println(numberDecimal + " chuyển sang hệ thập lục phân là: " + strHexadecimal);
        System.out.println(numberDecimal + " chuyển sang hệ bát phân là: " + strOctal);
    }
}
