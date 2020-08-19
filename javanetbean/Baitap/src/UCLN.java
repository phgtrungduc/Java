import java.util.*;
public class UCLN {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a,b,a1,b1,BCNN;
        System.out.println("nhap a: ");
        a = scanner.nextInt();
        System.out.println("nhap b: ");
        b = scanner.nextInt(); 
        a1=a;
        b1=b;
        while (a1!=b1){
            if (a1>b1) a1=a1-b1;
            else b1=b1-a1;
        }
        BCNN = (a*b)/a1;
        System.out.println("uoc chung lon nhat cua hai so "+a+" va "+b+ " la " +a1);
        System.out.println("boi chung nho nhat cua hai so "+a+" va "+b+ " la " +BCNN);
    }
}
