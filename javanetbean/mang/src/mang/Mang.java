
package mang;
import java.util.*;
public class Mang {
    public static void main(String[] args) {
        Scanner nhapxuat = new Scanner(System.in);
        int a[] = new int[100];
        int i,n;
        System.out.println("nhap so phan tu cua mang");
        n = nhapxuat.nextInt();
        for (i=0;i<n;i++){
            a[i]=  nhapxuat.nextInt();
        }
        for (i=0;i<n;i++){
            System.out.println("a["+i+"]="+a[i]);
        }
    }
    
}
