/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.bai4;
import java.util.*;
/**
 *
 * @author DUCBK
 */
public class Lab2Bai4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char test='N';
        Scanner nhapxuat= new Scanner(System.in);
        do {
            System.out.println("=======Vui long nhap lua chon=======");
            System.out.println("1.Giai phuong trinh bac nhat");
            System.out.println("2.Giai phuong trinh bac hai");
            System.out.println("3.Tinh tien dien");
            System.out.println("4.Thoat");
            int chon = nhapxuat.nextInt();
            switch(chon){
                case 1:{
                    System.out.println("Giai phuong trinh bac nhat");
                    System.out.print("Nhap he so bac nhat:a1= ");
                    float a1= nhapxuat.nextFloat();
                    System.out.print("Nhap he so bac hai: a2= ");
                    float b1= nhapxuat.nextFloat();
                    if (a1==0){
                        if (b1==0) System.out.println("phuong trinh co vo so nghiem");
                        else System.out.println("phuong trinh vo nghiem");
                    }
                    else{
                        System.out.printf("phuong trinh co nghiem: %f",-b1/a1);
                    }
                    break;
                }
                case 2:{
                    System.out.println("Giai phuong trinh bac hai");
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
                    break;
                }
                case 3:{
                    System.out.println("Tinh tien dien");
                    System.out.print("Nhap so dien: ");
                    int sodien = nhapxuat.nextInt();
                    int tien;
                    if(0<=sodien && sodien<=50){
                        tien = sodien*1000;
                    }
                    else {
                        tien = 50*1000+(sodien-50)*1200;
                    }
                    System.out.printf("So tien dien phai tra la:%d ",tien);
                    break;
                }
                case 4:{
                    System.out.println("Ban vua chon thoat?");
                    break;
                }
                default:{
                    System.out.println("Chuc nang ban nhap chua duoc ho tro");
                    break;
                }
            }
            System.out.println("\nBan co muon tiep tuc?");
            test = nhapxuat.next().charAt(0);
        }
        while(test=='Y'|| test=='y');
        }
    }
    

