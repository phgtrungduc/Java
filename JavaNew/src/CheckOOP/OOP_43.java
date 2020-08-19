package CheckOOP;

public class OOP_43 {
    private final String mathang="con cac";
    private static int gia;
    private  int maso;
    public final static double pi=3.14; //Nếu không có từ khóa static ở thuộc tính pi thì chỉ có
    //các biến đối tượng ví dụ: OOP_43 a = new OOP(43); rồi truy cập a.pi; khi có từ khóa static
    // ta có thể truy cập trực tiếp thông qua tên class : OOP_43.pi
    public String getMathang() {
        return mathang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }
    public void getInfor(){
        System.out.println("Mat hang: "+this.mathang);
        System.out.println("Gia     : "+this.gia);
        System.out.println("ID      : "+this.maso);
    }

    public static void main(String[] args) {
        double b= Math.pow(1,2);
        System.out.println(b);
    }
}
