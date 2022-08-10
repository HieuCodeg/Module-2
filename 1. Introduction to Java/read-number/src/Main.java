import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập so a: ");
        int a = sc.nextInt();
        String result = "";
        if (a > 999) {
            System.out.println("Số nhập quá lớn");
        } else {
            if (a > 99) {
                int b = a / 100;
                switch (b) {
                    case 1:
                        result += "one";
                        break;
                    case 2:
                        result += "two";
                        break;
                    case 3:
                        result += "three";
                        break;
                    case 4:
                        result += "four";
                        break;
                    case 5:
                        result += "five";
                        break;
                    case 6:
                        result += "six";
                        break;
                    case 7:
                        result += "seven";
                        break;
                    case 8:
                        result += "eight";
                        break;
                    case 9:
                        result += "nine";
                }
                result += " hundred and ";
                a = a % 100;
            }
            if (a >= 20) {
                int d = a / 10;
                switch (d) {
                    case 2:
                        result += "twenty";
                        break;
                    case 3:
                        result += "thirty";
                        break;
                    case 4:
                        result += "forty";
                        break;
                    case 5:
                        result += "fifty";
                        break;
                    case 6:
                        result += "sixty";
                        break;
                    case 7:
                        result += "seventy";
                        break;
                    case 8:
                        result += "eighty";
                        break;
                    case 9:
                        result += "ninety";
                        break;
                }
                a = a % 10;
            }
            if (a < 20) {
                switch (a) {
                    case 0:
                        result += " zero";
                        break;
                    case 1:
                        result += " one";
                        break;
                    case 2:
                        result += " two";
                        break;
                    case 3:
                        result += " three";
                        break;
                    case 4:
                        result += " four";
                        break;
                    case 5:
                        result += " five";
                        break;
                    case 6:
                        result += " six";
                        break;
                    case 7:
                        result += " seven";
                        break;
                    case 8:
                        result += " eight";
                        break;
                    case 9:
                        result += " nine";
                        break;
                    case 10:
                        result += " ten";
                        break;
                    case 11:
                        result += " eleven";
                        break;
                    case 12:
                        result += " twelve";
                        break;
                    case 13:
                        result += " thirteen";
                        break;
                    case 14:
                        result += " fourteen";
                        break;
                    case 15:
                        result += " fifteen";
                        break;
                    case 16:
                        result += " sixteen";
                        break;
                    case 17:
                        result += " seventeen";
                        break;
                    case 18:
                        result += " eighteen";
                        break;
                    case 19:
                        result += " nineteen";
                        break;
                }
            }
            System.out.println(result);
        }
    }
}