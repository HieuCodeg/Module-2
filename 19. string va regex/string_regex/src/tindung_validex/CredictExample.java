package tindung_validex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredictExample {
    private static final String CREDICT = "^[1-9]{1}[0-9]{15}$";

    public CredictExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CREDICT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
