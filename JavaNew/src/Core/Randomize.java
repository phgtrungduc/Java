package Core;

import java.util.Random;

public class Randomize {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt();
        System.out.println(n);
    }
}
