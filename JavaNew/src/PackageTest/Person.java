package PackageTest;

public class Person {
    private CMND a;
    private DOB b;

    public CMND getA() {
        return a;
    }

    public void setA(CMND a) {
        this.a = a;
    }

    public DOB getB() {
        return b;
    }

    public void setB(DOB b) {
        this.b = b;
    }
    public void hienthi(){
        System.out.println("Họ và tên: "+a.getName());
    }
}
