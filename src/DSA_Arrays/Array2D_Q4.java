package DSA_Arrays;

//Q4: Write a program to find the largest element of a given 2D array of integers.

import java.util.Scanner;

public class Array2D_Q4{

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

        int max=arr[0][0];

        System.out.println("Largest element of a given 2D array of integers:");

        for (int[] a:arr) {
            for (int x:a)
            {
                if (x>max)
                {
                    max = x;
                }
            }
        }

        System.out.println("Largest number: "+max);
    }
}

