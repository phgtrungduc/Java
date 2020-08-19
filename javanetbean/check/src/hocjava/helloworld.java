/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hocjava;
import test.ToTinh;
/**
 *
 * @author duc.pt173030
 */
public class helloworld {
    public static void main(String[] args) {
        Person Duc = new Person();
        Duc.setName("Phương Trung Đức");
        Duc.setID("20173030");
        Duc.setDOB("19/02/99");
        ToTinh b = new ToTinh();
        b.setCauNoi("Anh yêu em");
        b.setSoLan(10);
        b.hienthi();
    }
}
