package Core;

import java.util.Arrays;
import java.util.Collections;

public class Bai34_ClassArrays {
    public static void main(String[] args) {
        Integer []a={2,3,6,8,92,1,0,2,20,8};
        String b = Arrays.toString(a);
       // System.out.println(b);
       // int []c=a;//Phép gán nếu a thay dổi giá trị nào thì c cũng bị thay đổi theo
        a[1]=5;
//        for (int lon:c) {
//            System.out.println(lon);
//        }
        int []d;
        //d= Arrays.copyOf(a,a.length);//Dùng hàm copy không
        a[5]=9;
        for (int lon:a) {
    //        System.out.println(lon);
        }
        String[] str = new String[]{"anh","em","tao"};
        Arrays.sort(str, Collections.reverseOrder());  //dùng với kiểu String thì ok nhưng kiểu int thì đéo được
        Arrays.sort(a,Collections.reverseOrder());  //Phải đổi thành lớp Integer bao kiểu int thì mới được
        for (Integer lon:a) {
      //              System.out.print(" "+lon);
        }
        a= Arrays.copyOf(a,2*a.length);//dùng cách này tăng gấp đôi mảng
        int[]arr= {1,2,3,6,5,8,10,19};
        System.out.println(Arrays.binarySearch(arr,100));
    }
}
