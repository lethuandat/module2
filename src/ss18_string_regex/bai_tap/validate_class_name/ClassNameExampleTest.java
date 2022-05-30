package ss18_string_regex.bai_tap.validate_class_name;

import java.util.Scanner;

public class ClassNameExampleTest {
    public static void main(String[] args) {
        ClassNameExample classNameExample = new ClassNameExample();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input class name: ");
        String nameClass = scanner.nextLine();
        boolean isValid = classNameExample.validate(nameClass);
        System.out.println("Class name is " + isValid);
    }
}
