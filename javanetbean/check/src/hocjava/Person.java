/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hocjava;

/**
 *
 * @author duc.pt173030
 */
public class Person {
    private String name;
    private String ID;
    private String DOB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public void hienthi(){
        System.out.println("Họ và tên:       "+name);
        System.out.println("Mã số sinh viên: "+ID);
        System.out.println("Ngày sinh:       "+DOB);
    }
}
