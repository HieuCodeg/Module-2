package tinh_ket_qua_fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    public void testTranslate1() {
        int number = 31;
        String expected = "Fizz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(result, expected);
    }

    @Test
    public void testTranslate2() {
        int number = 52;
        String expected = "Buzz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(result, expected);
    }

    @Test
    public void testTranslate3() {
        int number = 523;
        String expected = "FizzBuzz";

        String result = FizzBuzzTranslate.translate(number);
        assertEquals(result, expected);
    }
}