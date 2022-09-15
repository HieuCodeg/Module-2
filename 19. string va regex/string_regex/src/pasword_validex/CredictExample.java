package pasword_validex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredictExample {
    private static final String CREDICT = "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!.#$@_+,?-]).{8,50})";

    public CredictExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CREDICT);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
