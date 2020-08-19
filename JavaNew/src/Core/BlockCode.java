package Core;

public class BlockCode {
    int n=5;//cái này tên là thuộc tính
    public static void main(String[] args) {
        int n=5;
        {
            n=6; //Trong java không cho phép
        }
        System.out.println(n);
    }
}
