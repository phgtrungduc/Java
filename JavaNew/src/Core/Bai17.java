package Core;

import java.util.Scanner;

public class Bai17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String c ;
        System.out.println("Nhap ten: ");
        String ten = scanner.nextLine();
        //scanner.nextLine();
        System.out.println("Nhap nhom mau: ");
        char nhomMau = scanner.nextLine().charAt(0);
        System.out.println("Ten: "+ten);
        System.out.println("Nhom mau: "+nhomMau);
        System.out.println(nhomMau);

    }
}