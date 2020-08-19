package Core;

import java.util.Scanner;

public class VietPhuongThuc {
    public static void nhapmang(int a[]){
        int n= a.length;
        Scanner in = new Scanner(System.in);
        for (int i=0;i<n;i++){
            System.out.print("Nhap a["+i+"]: ");
            a[i]=in.nextInt();
        }
    }
    public static void xuatmang(int a[]){
        int n=a.length;
        for (int i=0;i<n;i++){
            System.out.print(" "+a[i]);
        }
    }
    public static String[]tachtu (String a){
        String[] s = a.split(" ");
        return s;
    }
    public static void main(String[] args) {
//        int[] a= new int[10];
//        nhapmang(a);
//        xuatmang(a);
        Scanner in = new Scanner(System.in);
        String a= in.nextLine();
        String[]b= tachtu(a);
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}
