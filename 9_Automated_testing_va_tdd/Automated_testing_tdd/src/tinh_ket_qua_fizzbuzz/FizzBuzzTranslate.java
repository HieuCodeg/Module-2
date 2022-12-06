package tinh_ket_qua_fizzbuzz;

public class FizzBuzzTranslate {

    public static String translate(int number) {

        if (isFizz(number) && isBuzz(number))
            return "FizzBuzz";
        if (isFizz(number))
            return "Fizz";
        if (isBuzz(number))
            return "Buzz";
        return readNumber(number);
    }

    public static String readNumber(int number) {
        String result = "";
        while (number > 0) {

        }
        return result;
    }

    public static boolean isFizz(int number) {
        while (number > 0) {
            int lastUnit = number % 10;
            if (lastUnit == 3) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    public static boolean isBuzz(int number) {
        while (number > 0) {
            int lastUnit = number % 10;
            if (lastUnit == 5) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

}
