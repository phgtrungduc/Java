package PackageTest;

public class Vector1 {
    private double x;
    private double y;
    private double z;
    public Vector1(){}
    public Vector1(double x, double y,double z){
        this.x =x;
        this.y=y;
        this.z = z;
    }
    public Vector1 sum(Vector1 a, Vector1 b){
        Vector1 tong = new Vector1();
        tong.x = a.x +b.x;
        tong.y = a.y +b.y;
        tong.z = a.z + b.z;
        return tong;
    }
    public void display(){
        System.out.println("Tọa độ vector: ("+this.x+", "+this.y+" ," +this.z+")");
    }

    public static void main(String[] args) {
        Vector1 a = new Vector1(1,2,3);
        Vector1 b = new Vector1(4,5,6);
        Vector1 c = new Vector1();
        c= c.sum(a,b);
        c.display();
    }
}
