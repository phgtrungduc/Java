package Core;

public class Bai33 {
    public static void main(String[] args) {
        //cách khởi tạo mảng số 1
        int []a= {1,2,3,5,6,9,2,3,33,4};
        System.out.println(a.length);
        //Cách 2
        int []b= new int[100];
        a[0]=1;
        a[1]=2;
        System.out.println(b.length);
        //Cach 3
        int []c=new int []{2,3,5,9,8,1,12};
        System.out.println(c.length);
    }
}
