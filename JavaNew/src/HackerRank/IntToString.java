package HackerRank;

public class IntToString {
    public static void main(String[] args) {
        int n=100;
        String s= Integer.toString(n);//Cách 1
        String s1= String.valueOf(n);//Cách 2
        System.out.println(s1);
        System.out.println(s);
    }
}
