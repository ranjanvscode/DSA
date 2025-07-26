package DSA_Arrays;

//Q2: write a program to print the elements above the secondary diagonal in a user inputted square matrix.

import java.util.Scanner;

public class Array2D_Q2{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r,c;
        System.out.println("Number of rows");
        r= sc.nextInt();
        System.out.println("Number of column");
        c=sc.nextInt();

        int[][] arr = new int[r][c];

        System.out.println("Enter element:");

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println("printing element above the secondary line:");

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++)
            {
                if (i+j<c-1)
                {
                    System.out.print(arr[i][j]+" ");
                }
            }
        }
    }
}

