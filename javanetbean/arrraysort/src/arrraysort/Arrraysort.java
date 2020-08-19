/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrraysort;
import java.util.*;
public class Arrraysort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so phan tu cua mang: ");
        int n= Integer.parseInt(sc.nextLine());
        int a[]= new int[n];
        int i;
        for (i=0;i<n;i++){
            System.out.printf("a[%d]= ",i);
            a[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(a);
        for (i=0;i<n;i++){
            System.out.printf("\na[%d]= %d",i,a[i]);
        }
    }
    }
