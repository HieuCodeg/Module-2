package validex_ten_lop;

import validex_account.AccountExample;

public class TestClass {

    private static ClassExample classExample;

    public static final String[] validAccount = new String[]{"C0622G", "C0318G", "A3333M", "P0000H", "A0909K"};
    public static final String[] invalidAccount = new String[]{"c0622G", "C03108G", "A333M", "abcde"};

    public static void main(String args[]) {
        classExample = new ClassExample();
        for (String account : validAccount) {
            boolean isvalid = classExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = classExample.validate(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
    }

}
