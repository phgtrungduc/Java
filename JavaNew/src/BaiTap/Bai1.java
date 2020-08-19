package BaiTap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao chieu dai canh: ");
        int dai = in.nextInt();
        System.out.println("Nhao vao chieu rong hcn: ");
        int rong = in.nextInt();
        for (int i=0;i<dai;i++){
            for (int j=0;j<rong;j++){
                System.out.print("*  ");
            }
            System.out.println();
        }
    }
}
