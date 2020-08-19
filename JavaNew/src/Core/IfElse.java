package Core;

public class IfElse {
    public static void main(String[] args) {
        int x=5;
        int n=9;
        if (x>0) if (x==6) n=6;else n=100;//else sẽ thuộc về lệnh if gần nó nhất
        System.out.println(n);
    }
}
