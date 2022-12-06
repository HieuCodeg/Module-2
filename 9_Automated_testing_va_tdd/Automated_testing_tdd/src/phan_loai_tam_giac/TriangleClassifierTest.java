package phan_loai_tam_giac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void testClassifier1() {
        double a = 2;
        double b = 2;
        double c = 2;
        String expected = "Tam giác đều";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier2() {
        double a = 2;
        double b = 2;
        double c = 3;
        String expected = "Tam giác cân";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier3() {
        double a = 3;
        double b = 4;
        double c = 5;
        String expected = "Tam giác vuông";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier4() {
        double a = 8;
        double b = 2;
        double c = 3;
        String expected = "Không phải là tam giác";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier5() {
        double a = -1;
        double b = 2;
        double c = 1;
        String expected = "Không phải là tam giác";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier6() {
        double a = 0;
        double b = 1;
        double c = 1;
        String expected = "Không phải là tam giác";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier7() {
        double a = 2;
        double b = 6;
        double c = 5.7;
        String expected = "Tam giác thường";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }

    @Test
    void testClassifier8() {
        double a = -3;
        double b = -3;
        double c = -3;
        String expected = "Không phải là tam giác";
        String result=TriangleClassifier.classifier(a,b,c);
        assertEquals(result,expected);
    }
}