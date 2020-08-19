package OOP;

import CheckOOP.Student;

public class Bai40 {
    public static void main(String[] args) {
        Student st1 = new Student("Phương Trung Đức","CNTT09-K62",20173030,"19/02/1999");
        Student st2= new Student();
        st2 = null;
        System.out.println(st2);
    }
}
