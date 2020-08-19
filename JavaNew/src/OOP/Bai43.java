package OOP;

import CheckOOP.OOP_43;

public class Bai43 {
    public static void main(String[] args) {
        OOP_43 hang1 = new OOP_43();
        OOP_43 hang2 = new OOP_43();
        hang1.setMaso(200);
        hang1.setMaso(300);
        hang1.getInfor();
        hang2.getInfor();
        hang1.equals(hang2);
        System.out.println(hang1.pi);
    }
}
