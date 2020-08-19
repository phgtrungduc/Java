package OOP;

public class TachTen {
    private String name;
    private String[] splitName = new String[5];
    private void tachten(){
        splitName = name.split(" ");
    }
    public void ho(){
        tachten();
        System.out.println("Họ: "+splitName[0]);
    }
    public void getName(){
        int dem=0;
        tachten();
        for (int i = 0; i <name.length() ; i++) {
            char a= name.charAt(i);
            if (a==' ') dem++;
        }
        System.out.println("Tên: "+splitName[dem]);
    }

    public void setName(String name) {
        this.name = name;
    }
}
