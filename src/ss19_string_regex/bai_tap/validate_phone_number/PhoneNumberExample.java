package ss19_string_regex.bai_tap.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExample {
    /**
     * Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)
     * x là ký tự số
     * Không chứa các ký tự đặc biệt
     */

    private static final String PHONE_NUMBER_REGEX = "(\\(\\d{2}\\))-(\\(0\\d{9}\\))";

    public PhoneNumberExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
