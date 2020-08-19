package Inheritance;

public class ChaCon {
    public static void main(String[] args) {
        FatherClass cha = new FatherClass("Phương Trung Đức","19/02/99","113717588");
        cha.hienthi();
        System.out.println();
        cha = new ChildClass("Lê Quang Tùng","22/11/99","1137175898","36","DY16A1");
        cha.hienthi();
    }
}
