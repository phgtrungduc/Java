package Core;

public class ClassStringBuilder {
    public static void main(String[] args) {
        StringBuilder a= new StringBuilder();
        a.append("anhday");
        //a.appendCodePoint(65);//add thêm vào stringb kí tự có ascii 65
//        a.insert(1,32);
//        a.insert(1,'c');
//        a.setCharAt(0,'A');
        a.delete(0,1);//xóa từ vị trí 0, xóa 1 khoảng có độ dài 1-0
        System.out.println(a);
        System.out.println(a.length());//độ dài của stringbuilder
        String b = a.toString();
    }
}
