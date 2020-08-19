package CheckOOP;

public class Student {
    private String name,lopSV;
    private int ID;
    private String DOB;
    public Student(String name, String lopSV,int ID,String DOB){
        this.name = name;
        this.lopSV = lopSV;
        this.ID=ID;
        this.DOB=DOB;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLopSV() {
        return lopSV;
    }

    public void setLopSV(String lopSV) {
        this.lopSV = lopSV;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public void getInfor(){
        System.out.println("Ho va ten: "+this.name);
        System.out.println("Lop      : "+this.lopSV);
        System.out.println("Ma so SV : "+this.ID);
        System.out.println("Ngay sinh: "+this.DOB);
    }
    public int nextStudentID(int sothutu){
        return sothutu+this.ID;
    }
}
