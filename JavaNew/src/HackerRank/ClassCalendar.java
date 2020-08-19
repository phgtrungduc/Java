package HackerRank;

import java.util.Calendar;

public class ClassCalendar {
//    public void hienthi(Calendar a){
//        System.out.println("Ngay: "+a.getTime());
//    }
    public static void main(String[] args) {
        Calendar test = Calendar.getInstance();
        //System.out.println(test.getTime());
        test.set(2010,3,12);
        System.out.println(test.getTime());
        System.out.println(test.get(Calendar.DAY_OF_WEEK));
        System.out.println(test.get(Calendar.DAY_OF_MONTH));
        System.out.println(test.get(Calendar.MONTH));
        System.out.println(test.get(Calendar.YEAR));
    }
}
