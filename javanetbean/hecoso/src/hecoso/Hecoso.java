/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hecoso;

import java.util.*;
public class Hecoso {
    public static void main(String[] args) {
        int n,b,i=0,j;
        int a[]= new int[100];
        Scanner nhapxuat = new Scanner(System.in);
        System.out.println("nhap so can chuyen: ");
        n = nhapxuat.nextInt();
        System.out.println("He co so can chuyen sang: ");
        b = nhapxuat.nextInt();
        while (n!=0){
            n=n/b;
            a[i]=n%b;
            i++;
        }
    for (j=i;j>=0;j=j-1){
        System.out.println("a["+j+"]="+a[j]+);
    }
    }
    
}
