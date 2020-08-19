package HackerRank;

public class StaticBlock {    //static block dùng để khởi tạo một class trước khi vào hàm main
    static private int i=0;
    static {
        i=5;
        System.out.println("");
    }
    public static void main(String[] args) {
        System.out.println(StaticBlock.i);
    }
}
