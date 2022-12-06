package phan_loai_tam_giac;

public class TriangleClassifier {

    public static String classifier(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c)
                return "Tam giác đều";
            if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b)
                return "Tam giác vuông";
            if (a == b || b == c || a == c)
                return "Tam giác cân";
            return "Tam giác thường";
        }
        return "Không phải là tam giác";
    }
}
