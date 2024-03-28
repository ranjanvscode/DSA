package DSA_Arrays;

//Q3: write a program to print the elements of both the diagonals in a user inputted square matrix in any order.

import java.util.Scanner;

public class Array2D_Q3{

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

        System.out.println("Print the elements of both the diagonals:");
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++)
            {
                if (i+j==c-1 || i==j)
                {
                    System.out.print(arr[i][j]+" ");
                }
            }
        }
    }
}

