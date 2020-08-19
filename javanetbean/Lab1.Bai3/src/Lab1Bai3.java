/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author DUCBK
 */
public class Lab1Bai3 {
    public static void main(String[] args) {
        Scanner nhapxuat= new Scanner(System.in);
        System.out.print("nhap he so bac hai : a= ");
        float a = nhapxuat.nextFloat();
        System.out.print("nhap he so bac hai : b= ");
        float b = nhapxuat.nextFloat();
        System.out.print("nhap he so bac hai : c= ");
        float c = nhapxuat.nextFloat();
        float delta = b*b-4*a*c;
        if (delta < 0) System.out.print("Phuong trinh vo nghiem");
        else if (delta==0){
            System.out.printf("phuong trinh co nghiem kep x1=x2= %f",-b/(2*a));
        }
        else if (delta>0){
            System.out.println("phuong trinh co hai nghiem phan biet");
            System.out.printf("x1= %f",(-b-Math.sqrt(delta))/(2*a));
            System.out.printf("\nx2= %f",(-b+Math.sqrt(delta))/(2*a));
        }
    }
    
}
