package Inheritance;

public class FatherClass {
    private String name;
    private String DOB;
    private String personID;
    public FatherClass(){}
    public FatherClass(String name, String DOB, String personID) {
        this.name = name;
        this.DOB = DOB;
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
    public void hienthi(){
        System.out.println("Họ và tên: "+name);
        System.out.println("Ngày sinh: "+DOB);
        System.out.println("CMND     : "+personID);
    }

}
