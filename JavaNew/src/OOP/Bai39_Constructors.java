package OOP;

import CheckOOP.Student;

public class Bai39_Constructors {
    public static void main(String[] args) {
        Student st1= new Student(); //
        Student st2 = new Student("Phương Trung Đức","CNTT09-K62",20173030,"19/02/1999");
        st2.getInfor();
    }
}
