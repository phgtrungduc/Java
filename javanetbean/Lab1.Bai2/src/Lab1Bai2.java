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
public class Lab1Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner nhapxuat= new Scanner(System.in);
        System.out.println("Nhap vao hai canh cua hinh chu nhat");
        double dai = nhapxuat.nextDouble();
        double rong = nhapxuat.nextDouble();
        System.out.printf("canh co do dai nho hon la: %.3f",Math.min(dai,rong));
        System.out.printf("chu vi hinh chu nhat la: %.3f, va dien tich cua no la: %.3f",2*(dai+rong),dai*rong);
        
    }
    
}
