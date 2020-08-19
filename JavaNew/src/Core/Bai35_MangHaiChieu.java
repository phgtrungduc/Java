package Core;

import java.util.Arrays;

public class Bai35_MangHaiChieu {
    public static void main(String[] args) {
        int[][]a= new int [4][6];
        int[][] b= {{1,2,3,5},{5,6,9,4},{8,7,9,1}};
        for (int i=0;i<3;i++){
            for (int j=0;j<4;j++){
                System.out.print(" "+b[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n"+b[0].length);
        System.out.println(Arrays.deepToString(b));
        for(int[] cac:b){
            for(int lon:cac){
                System.out.print(" "+lon);
            }
            System.out.println();
        }
        int[] hang1= {1};
        int[] hang2={5,6};
        int[] hang3={8,7,9};
        b[0]=hang1;
        b[1]=hang2;
        b[2]=hang3;
        System.out.println(b);
        int dem=1;
        for (int i=0;i<3;i++){
            for (int j=0;j<dem;j++){
                System.out.print(" "+b[i][j]);
            }
            dem++;
            System.out.println();
        }
    }
}
