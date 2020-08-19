package Core;

public class SwitchCase {
    public static void main(String[] args) {
        String input = "YES";
        switch (input.toLowerCase()){
            case "yes": {
                System.out.println("lon");
                break;
            }
            default:{
                System.out.println("con cac");
            }
        }
    }
}
