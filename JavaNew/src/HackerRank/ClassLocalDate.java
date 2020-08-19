package HackerRank;

import java.time.LocalDate;
import java.util.Calendar;

public class ClassLocalDate {
    public static void main(String[] args) {
        LocalDate test;
        test =  LocalDate.of(2019,7,21);
        System.out.println(test.getDayOfWeek()); //tìm ra thứ tương ứng với ngày tạo ra ở biến test
    }
}
