import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRegex {

    private static final String ACCOUNT_REGEX = "^[_A-Za-z0-9]{6,}$";

    public AccountRegex() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
