package Inheritance;

public class ChildClass extends FatherClass {
    private String studentID;
    private String nameClass;
    public ChildClass(){
    }
    public ChildClass(String name,String DOB,String personID,String studentID,String nameClass) {
        super(name,DOB,personID);
        this.studentID = studentID;
        this.nameClass= nameClass;
    }
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    @Override
    public void hienthi() {
        super.hienthi();
        System.out.println("Mã số SV: "+studentID);
        System.out.println("Lớp     : "+nameClass);
    }
}
