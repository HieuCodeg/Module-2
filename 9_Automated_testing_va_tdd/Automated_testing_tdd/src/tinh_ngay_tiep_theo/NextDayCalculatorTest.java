package tinh_ngay_tiep_theo;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextDayCalculatorTest {

    @Test
    public void testFindNextDay1() throws ParseException {
        String dateString = "01/01/2018";
        String expected = "02/01/2018";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }

    @Test
    public void testFindNextDay2() throws ParseException {
        String dateString = "31/01/2018";
        String expected = "01/02/2018";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }
    @Test
    public void testFindNextDay3() throws ParseException {
        String dateString = "30/04/2018";
        String expected = "01/05/2018";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }
    @Test
    public void testFindNextDay4() throws ParseException {
        String dateString = "28/02/2018";
        String expected = "01/03/2018";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }
    @Test
    public void testFindNextDay5() throws ParseException {
        String dateString = "29/02/2020";
        String expected = "01/03/2020";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }
    @Test
    public void testFindNextDay6() throws ParseException {
        String dateString = "31/12/2018";
        String expected = "01/01/2019";

        String result = NextDayCalculator.findNextDay(dateString);
        assertEquals(expected,result);

    }
}