package Core;

public class DemoConstructor {
    public static boolean check(int x){
        if (x%2==0) return true;
        else return false;
    }
    public static void main(String[] args) {
        int x=5;
        System.out.println(check(x));
    }
}
