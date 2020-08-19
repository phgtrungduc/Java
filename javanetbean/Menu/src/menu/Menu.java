/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;
import java.util.*;
public class Menu {
    public static void main(String[] args) {
        int chon;
        char test1 = 'N';
        Scanner nhapxuat = new Scanner(System.in);
        do {
            System.out.println("===========Vui long nhap lua chon cua ban==========");
            System.out.println("1.Noi nay co anh");
            System.out.println("2.Bua yeu");
            System.out.println("3.Sai nguoi, sai thoi diem");
            System.out.println("4.Yeu");
            System.out.println("5.Thoat");
            chon =  nhapxuat.nextInt();
            switch(chon){
            case 1:{
                System.out.println("Bai hat cua Son Tung MTP");
                break;
            }
            case 2:{
                System.out.println("Bai hat cua Bich Phuong");
                break;
            }
            case 3:{
                System.out.println("Bai hat cua Thanh Hung");
                break;
            }
            case 4:{
                System.out.println("Bai hat cua Min");
                break;
            }
            case 5:{
                System.out.println("Ban muon thoat?");
                break;
            }
            default:{
                System.out.println("Lua chon ban nhap chua duoc ho tro");
                break;
            }
            }
        System.out.println("Ban co muon tiep tuc? (Y/N)");
        test1 = nhapxuat.next().charAt(0);
        }
        while (test1=='Y'||test1=='y');
        
    }
    
}
