/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuanhoachuoi;
import java.util.*;
public class songuyento {
    public static void main(String[] args) {
        Scanner nhapxuat= new Scanner(System.in);
        int n,i;
        boolean test= true;
        do{
            System.out.println("Nhap vao so nguyen can kiem tra: ");
            n= nhapxuat.nextInt();
        }
        while (n<=1);
        for (i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                test = false;
                break;
            }
        }
        if (test==true) System.out.println("La so nguyen to");
        else System.out.println("Khong phai la so nguyen to");
    }
    
}
