package Inheritance;

public class CheckClass {
    public static void  swap(Employee a,Employee b){
        Employee tmp = a;
        a=b;
        b=tmp;
    }
    public static void main(String[] args) {
        Employee Duc = new Employee();
        Duc.setID("20173030");
        Duc.setName("Phương Trung Đức");
        Duc.setSalary(30_000_000);
        Employee Tung = new Employee();
        Duc.setID("20173035");
        Duc.setName("Lê Quang Tùng");
        Duc.setSalary(20_000_000);
        swap(Duc,Tung);
        System.out.println(Duc.getName());
    }
}
