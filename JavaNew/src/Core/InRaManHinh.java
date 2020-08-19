package Core;

public class InRaManHinh {
    public static void main(String[] args) {
        int a = 998232323;
        System.out.printf("%,d",a);//thêm dấu , trước chữ d để tách cứ 3 số sẽ có 1 dấu phẩy VD: 12,234,123
        System.out.println();
        int b=20;
        System.out.printf("%03d",b);//%03f dúng để in ra số có lớn hơn hoặc bằng 3 chữ số
                                     //, nếu ít hơn sẽ có số 0 ở đầu cho đủ 3 chữ số
    }
}
