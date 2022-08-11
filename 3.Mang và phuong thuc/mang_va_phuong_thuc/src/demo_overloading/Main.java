package demo_overloading;

public class Main {
    public static void main(String[] args) {

        int a = 5, b = 10;
        float c = 5, d = 10;
        String e = "Code", g = "gym";
        System.out.println(a + " + " + b + " = " + add( a, b));
        System.out.println(c + " + " + d + " = " + add( c, d));
        System.out.println(e + " + " + g + " = " + add( e, g));
     }

    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }

    public static String add(String a, String b) {
        return  a + b;
    }
}
