package Core;

public class Bai15 {
    public static void main(String[] args) {
        String myName="anhyeuema";
        char a[] = new char[100];
        a = myName.toCharArray();
        String yourName="a";
        //String conCec = myName.rep('a','A');
        a[2]='o';
        int b = 5;
        double c = Math.sqrt(b);
        System.out.println(c);
    }
}
