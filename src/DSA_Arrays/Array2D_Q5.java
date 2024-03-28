package DSA_Arrays;

import java.util.Scanner;

public class Array2D_Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r,c;
        System.out.println("Number of rows(Odd no.)");
        r= sc.nextInt();
        System.out.println("Number of column(Odd no.)");
        c=sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter element:");

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++)
            {
               arr[i][j]=sc.nextInt();
            }
        }

        System.out.println("Displays the elements of middle row and middle column:");

        for (int i=0;i<r;i++)
        {
            System.out.print(arr[i][c/2]+" ");
        }

        for (int i=0;i<r;i++)
        {
            if(i==c/2) continue;
            System.out.print(arr[r/2][i]+" ");
        }

    }
}
