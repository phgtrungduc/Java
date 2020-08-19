/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

/**
 *
 * @author DUCBK
 */
public class hammain {
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.input();
        System.out.printf("%s o do tuoi la: %d da co thu nhap la %f",emp.fullname,emp.tuoi,emp.salary);
    }
}
