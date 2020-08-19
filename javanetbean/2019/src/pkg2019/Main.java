/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2019;
import java.util.*;
/**
 *
 * @author DUCBK
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner nhapxuat = new Scanner(System.in);
        int a[] = new int[100];
        int i;
        System.out.println("Nhap so phan tu cua mang: ");
        int n = Integer.parseInt(nhapxuat.nextLine());
        for (i=0;i<n;i++){
            System.out.printf("Nhap a[%d]",i);    
            a[i]= Integer.parseInt(nhapxuat.nextLine());        
        }
        int trungbinh;
        for(int x:a){
            System.out.printf("%d",x);
        }
    }
    
}
