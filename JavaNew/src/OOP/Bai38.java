package OOP;

import java.util.Date;

public class Bai38 {
    public static void main(String[] args) {
        PublicPart a= new PublicPart();
        Date ngay = new Date();
        System.out.println(ngay);
        Date date = new Date(1000,3,3);
        System.out.println(date);
    }
}
//boolean after(Date date) : Tests if current date is after the given date.
//boolean before(Date date) : Tests if current date is before the given date.
//int compareTo(Date date) : Compares current date with given date. Returns 0 if the argument Date is equal to the Date; a value less than 0 if the Date is before the Date argument; and a value greater than 0 if the Date is after the Date argument.
//long getTime() : Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
//void setTime(long time) : Changes the current date and time to given time.
