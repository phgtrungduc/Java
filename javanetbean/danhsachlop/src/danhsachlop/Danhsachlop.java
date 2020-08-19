/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhsachlop;
import java.util.*;
import java.util.Arrays;
/**
 *
 * @author DUCBK
 */
public class Danhsachlop {
    public static void main(String[] args) {
        Scanner nhapxuat = new Scanner(System.in);
        String[] a = new String[100];
        int diem[]= new int[100];
        System.out.println("Nhap so hoc sinh: ");
        int n =  Integer.parseInt(nhapxuat.nextLine());
        int i;
        for (i=0;i<n;i++){
            /*System.out.printf("ten hoc sinh thu %d:\n",i+1);
            a[i]= nhapxuat.nextLine();*/
            System.out.printf("diem hoc sinh thu %d:\n",i+1);
            diem[i]= Integer.parseInt(nhapxuat.nextLine());
        }
        Arrays.sort(diem);
        for (i=0;i<n;i++){
            System.out.println(diem[i]);
        }
           
}
}