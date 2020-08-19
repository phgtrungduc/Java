/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;
import java.util.*;
/**
 *
 * @author DUCBK
 */
public class Test2 {
     public static void main(String[] args) {
        Scanner nhapxuat= new Scanner(System.in);
        int a[]= new int[100];
        for (int i=0;i<10;i++){
            System.out.printf("\na[%d]= ",i);
            a[i]= nhapxuat.nextInt();
        }
        for (int i=0;i<10;i++){
            System.out.printf("\na[%d]=%d ",i,a[i]);
        }
    }
    
}
