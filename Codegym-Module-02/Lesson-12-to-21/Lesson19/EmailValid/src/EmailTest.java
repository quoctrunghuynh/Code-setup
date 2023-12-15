import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailTest {
    public static final String[] validEmail = new String[]{"hqtrung@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String[] args) {
        EmailRegex emailRegex = new EmailRegex();
        for (String email : validEmail) {
            boolean isValid = emailRegex.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
        for (String email : invalidEmail) {
            boolean isValid = emailRegex.validate(email);
            System.out.println("Email is " + email + " is valid: " + isValid);
        }
    }
}
