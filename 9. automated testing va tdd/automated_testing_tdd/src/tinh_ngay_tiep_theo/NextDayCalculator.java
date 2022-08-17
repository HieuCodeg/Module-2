package tinh_ngay_tiep_theo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class NextDayCalculator {
    public static String findNextDay(String dateString) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(dateString); // parse dateString thành kiểu Date
        } catch (ParseException e) { // quăng lỗi nếu dateString ko hợp lệ
            System.out.println("Invalid date");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(dateString));
        cal.add(Calendar.DATE, 1);
        String nextDate = df.format(cal.getTime());

        return nextDate;
    }

//    public static void main(String[] args) throws ParseException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập ngày: ");
//        String dateString = sc.nextLine();
//        System.out.println(findNextDay(dateString));
//
//    }
}
