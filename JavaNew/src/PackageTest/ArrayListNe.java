package PackageTest;

import java.util.ArrayList;

public class ArrayListNe {
    public static void main(String[] args) {
        ArrayList  a = new ArrayList();
        a.add(5);
        a.add("con cac");
        for (int i = 0; i <2 ; i++) {
            System.out.println(a.get(i));
        }
    }
}
