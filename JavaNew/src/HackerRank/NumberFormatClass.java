package HackerRank;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class NumberFormatClass {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        System.out.println(nf);
    }
}
