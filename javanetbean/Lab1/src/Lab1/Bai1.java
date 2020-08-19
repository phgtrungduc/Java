/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;
import java.util.*;
/**
 *
 * @author DUCBK
 */
public class Bai1 {
    public static void main(String[] args) {
        Scanner nhapxuat = new Scanner(System.in);
        System.out.println("nhap ho va ten: ");
        String hoten = nhapxuat.nextLine();
        System.out.println("nhap diem trung binh");
        double diemtb = nhapxuat.nextDouble();
        System.out.printf("%s : %f diem",hoten,diemtb);
    }
    
}
