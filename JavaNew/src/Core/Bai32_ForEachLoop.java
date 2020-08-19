package Core;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Bai32_ForEachLoop {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(Paths.get("D:\\Java.txt"), "UTF-8");
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        String b = "anh yeu em";
        String[] bs = b.split(" ");//tách thành các mảng string sau mỗi dấu " "
        for (String lon : bs) {
            System.out.print(lon);
            System.out.println(1);
        }
    }
}
