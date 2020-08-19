package OOP;

import CheckOOP.Student;

public class Bai37 {
    public static void main(String[] args) {
        Student st1 = new Student();
        st1.setName("Phuong Trung Duc");
        st1.setID(20173030);
        st1.setLopSV("CNTT09");
        st1.setDOB("19/02/1999");
       // st1.getInfor();
        Student st2= new Student("Phuong Trung Duc","CNTT09",20173030,"19/02/99");
        st2.getInfor();
    }
}
