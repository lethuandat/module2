package ss01_intro_to_java.bai_tap;

import java.util.Scanner;

public class NumberToText {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");

        int number = scanner.nextInt();
        int number2 = number % 10;
        int number3 = number / 10;
        int number4 = number / 100;
        int number5 = (number % 100) / 10;
        int number6 = (number % 100) % 10;
        String s1 = null, s2 = null, s3 = null, s4 = null;

        if (number >= 0 && number < 10) {
            switch (number) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
            }
        } else if (number >= 10 && number < 20) {
            switch (number2) {
                case 0:
                    System.out.println("ten");
                    break;
                case 1:
                    System.out.println("eleven");
                    break;
                case 2:
                    System.out.println("twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("fourteen");
                    break;
                case 5:
                    System.out.println("fifteen");
                    break;
                case 6:
                    System.out.println("sixteen");
                    break;
                case 7:
                    System.out.println("seventeen");
                    break;
                case 8:
                    System.out.println("eighteen");
                    break;
                case 9:
                    System.out.println("nineteen");
                    break;
            }
        } else if (number >= 20 && number < 100) {
            switch (number3) {
                case 2:
                    s1 = "twenty";
                    break;
                case 3:
                    s1 = "thirty";
                    break;
                case 4:
                    s1 = "forty";
                    break;
                case 5:
                    s1 = "fifty";
                    break;
                case 6:
                    s1 = "sixty";
                    break;
                case 7:
                    s1 = "seventy";
                    break;
                case 8:
                    s1 = "eighty";
                    break;
                case 9:
                    s1 = "ninety";
                    break;
                default:
                    System.out.println("out of ability");
            }
            switch (number2) {
                case 0:
                    s2 = "";
                    break;
                case 1:
                    s2 = "one";
                    break;
                case 2:
                    s2 = "two";
                    break;
                case 3:
                    s2 = "three";
                    break;
                case 4:
                    s2 = "four";
                    break;
                case 5:
                    s2 = "five";
                    break;
                case 6:
                    s2 = "six";
                    break;
                case 7:
                    s2 = "seven";
                    break;
                case 8:
                    s2 = "eight";
                    break;
                case 9:
                    s2 = "nine";
                    break;
                default:
                    System.out.println("out of ability");
            }
            System.out.print(s1 + " " + s2);
        } else if (number >= 100 && number < 1000) {
            switch (number4) {
                case 1:
                    s3 = "one";
                    break;
                case 2:
                    s3 = "two";
                    break;
                case 3:
                    s3 = "three";
                    break;
                case 4:
                    s3 = "four";
                    break;
                case 5:
                    s3 = "five";
                    break;
                case 6:
                    s3 = "six";
                    break;
                case 7:
                    s3 = "seven";
                    break;
                case 8:
                    s3 = "eight";
                    break;
                case 9:
                    s3 = "nine";
                    break;
                default:
                    System.out.println("out of ability");
            }
            switch (number5) {
                case 0:
                    s1 = "";
                    break;
                case 1:
                    switch (number6) {
                        case 0:
                            s4 = "ten";
                            break;
                        case 1:
                            s4 = "eleven";
                            break;
                        case 2:
                            s4 = "twelve";
                            break;
                        case 3:
                            s4 = "thirteen";
                            break;
                        case 4:
                            s4 = "fourteen";
                            break;
                        case 5:
                            s4 = "fifteen";
                            break;
                        case 6:
                            s4 = "sixteen";
                            break;
                        case 7:
                            s4 = "seventeen";
                            break;
                        case 8:
                            s4 = "eighteen";
                            break;
                        case 9:
                            s4 = "nineteen";
                            break;
                        default:
                            System.out.println("out of ability");
                    }
                    break;
                case 2:
                    s1 = "twenty";
                    break;
                case 3:
                    s1 = "thirty";
                    break;
                case 4:
                    s1 = "forty";
                    break;
                case 5:
                    s1 = "fifty";
                    break;
                case 6:
                    s1 = "sixty";
                    break;
                case 7:
                    s1 = "seventy";
                    break;
                case 8:
                    s1 = "eighty";
                    break;
                case 9:
                    s1 = "ninety";
                    break;
                default:
                    System.out.println("out of ability");
            }
            switch (number6) {
                case 0:
                    s2 = "";
                    break;
                case 1:
                    s2 = "one";
                    break;
                case 2:
                    s2 = "two";
                    break;
                case 3:
                    s2 = "three";
                    break;
                case 4:
                    s2 = "four";
                    break;
                case 5:
                    s2 = "five";
                    break;
                case 6:
                    s2 = "six";
                    break;
                case 7:
                    s2 = "seven";
                    break;
                case 8:
                    s2 = "eight";
                    break;
                case 9:
                    s2 = "nine";
                    break;
                default:
                    System.out.println("out of ability");
            }
            if (number5 == 1) {
                System.out.println(s3 + " hundred and " + s4);
            } else if (number5 == 0 && number6 == 0) {
                System.out.println(s3 + " hundred");
            } else {
                System.out.print(s3 + " hundred and " + s1 + " " + s2);
            }
        }
    }
}
