package test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duc.pt173030
 */
public class ToTinh {
    private String cauNoi;
    private int soLan;

    public String getCauNoi() {
        return cauNoi;
    }

    public void setCauNoi(String cauNoi) {
        this.cauNoi = cauNoi;
    }

    public int getSoLan() {
        return soLan;
    }

    public void setSoLan(int soLan) {
        this.soLan = soLan;
    }
    public void hienthi(){
        System.out.println("Anh chàng đã nói:\" "+cauNoi+" \" với số lần tổng cộng là: "+soLan);
    }
}
