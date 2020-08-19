package HackerRank;

import java.util.Date;

public class ClassDate {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);// hiển thị thời gian chạy chương trình
        System.out.println(now.getTime()); // số mili giây từ 00:00:00 ngày 1/1/1970 đến thời điểm chạy
        long nowtomilis=now.getTime();
        Date random = new Date(nowtomilis +(24*60*60*1000L));//số mi li giây từ 1970 để in ra ngày mai
        System.out.println(random);
        System.out.println(random.after(now));//Kiểm tra xem random có phải ngày sau now không
    }
}
