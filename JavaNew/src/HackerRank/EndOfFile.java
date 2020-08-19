package HackerRank;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(Paths.get("D://Java.txt"),"UTF-8");
        String[]a= new String[15];
        int i=0;
        while(in.hasNext()){
            a[i]=in.nextLine();
            i++;
        }
        System.out.println(i);
        for (String lon:a) {
            System.out.println(lon);
        }
    }
}
