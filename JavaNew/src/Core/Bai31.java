package Core;

import java.util.Scanner;

public class Bai31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String []a= new String[10];
        int []b= new int[10];
        b[0]=1;
        char []d= new char [100];
        d = in.nextLine().toCharArray(); // Nhập vào chuỗi dạng char
        char e = in.nextLine().charAt(0); // Nhaạp vào 1 kí tự
        for (int i=0;i<10;i++){
            System.out.println("Lan thu: "+i);
            System.out.println(a[i]);//chuỗi khởi tạo có giá trị là null vì vậy phải khởi tạo chuỗi rỗng
            System.out.println(b[i]);//mảng số được khởi tạo giá trị là 0
        }
        int []f= new int[10];
        f=b;
        System.out.println(f[0]);
        System.out.println(d);
        System.out.println("Do dai mang: "+a.length);
        String c = a[0] + "on";
        System.out.println(c);
    }
}
