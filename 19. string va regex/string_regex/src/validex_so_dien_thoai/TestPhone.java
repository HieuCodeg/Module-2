package validex_so_dien_thoai;

import java.util.List;

public class TestPhone {
    private static PhoneExample phoneExample;

    public static final String[] validAccount = new String[]{"(84)-(0978489648)", "(00)-(0000000000)"};
    public static final String[] invalidAccount = new String[]{"(a8)-(22222222)","98-22222222"};

    public static void main(String args[]) {
        phoneExample = new PhoneExample();
        for (String account : validAccount) {
            boolean isvalid = phoneExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = phoneExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
    }
}
