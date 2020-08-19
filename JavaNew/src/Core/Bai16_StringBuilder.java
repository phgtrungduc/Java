package Core;

public class Bai16_StringBuilder {
    public static void main(String[] args) {
        StringBuilder conCec = new StringBuilder("Phuong ");
        conCec.append("Trung");
        conCec.replace(0,3,"Long");
        System.out.println(conCec);
    }
}
