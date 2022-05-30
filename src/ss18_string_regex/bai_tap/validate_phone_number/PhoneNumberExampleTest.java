package ss18_string_regex.bai_tap.validate_phone_number;

import java.util.Scanner;

public class PhoneNumberExampleTest {
    public static void main(String[] args) {
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input phone number: ");
        String phoneNumber = scanner.nextLine();
        boolean isValid = phoneNumberExample.validate(phoneNumber);
        System.out.println("Phone number is " + isValid);
    }
}
