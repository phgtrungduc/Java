/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;
import java.util.*;
/**
 *
 * @author DUCBK
 */

public class Employee {
    Scanner sc = new Scanner(System.in);
    public String fullname;
    public int tuoi;
    public double salary;
    public void input(){
        System.out.println("Nhap ten");
        fullname = sc.nextLine();
        System.out.println("Nhap tuoi");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap luong");
        salary = Integer.parseInt(sc.nextLine());
    }
}
