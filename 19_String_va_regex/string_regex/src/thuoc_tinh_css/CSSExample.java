package thuoc_tinh_css;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSSExample {
    private static final String PHONE_NUMBER = "^style=\" ";

    public CSSExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
