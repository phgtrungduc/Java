package OOP;

public class PublicPart {
    private int ID;
    public String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void hienthi(){
        System.out.println("Mã số sinh viên: "+this.ID);
        System.out.println("Tên:             "+this.name);
    }
}
