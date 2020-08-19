package Core;

public class ClassString {
    public static void main(String[] args) {
        String b= "em cung yeu anh";
        String a= b.substring(0,4);// chuỗi con bắt đầu từ vị trí 0, độ dài là 4-0=4
        int d = 13;
        String c = b+d;//ghép string với 1 số thì số sẽ được chuyển sag kiểu string rồi ghép vào string kia
       // System.out.println(c);
        char ch = 'l';
        String first = "A";
        String second = "A";
        String third = "C";
        String four = String.join("-",first,second,third);//Giữa các string có dấu -
        String test = "THPT Luong Son";
        String tong = first + second+third+ch;
        System.out.println(tong);
        System.out.println(first.equals(second));
    }
}
