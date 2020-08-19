package OOP;

public class Bai52_TestLopCon {
    private int giatri;
    public Bai52_TestLopCon(){
        System.out.println("Ban vua tao ra 1 doi tuong moi");
    }//constructor kiểu khác

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }
    public boolean checksonguyento(){
        int n= this.giatri;
        if (n==1) return false;
        for (int i = 2; i <n ; i++) {
            if (n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Bai52_TestLopCon hello = new Bai52_TestLopCon();
        hello.setGiatri(13);
        System.out.println(hello.checksonguyento());
    }

}
