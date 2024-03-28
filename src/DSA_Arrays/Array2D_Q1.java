package DSA_Arrays;

// Q1: Take m and n input from the user and m * n integer inputs from user and print the following:

import java.util.Scanner;

public class Array2D_Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r,c,pos=0,neg=0,odd=0,even=0,zero=0;
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

        for (int[] a : arr) {
            for (int x : a)
            {
                if (x>0)
                {
                    pos++;
                }
                else if (x<0)
                {
                    neg++;
                }else {
                    zero++;
                }

                if (x%2==0)
                {
                    even++;
                }else {
                    odd++;
                }
            }
        }

        System.out.println("number of positive numbers: "+pos);
        System.out.println("number of negative numbers: "+neg);
        System.out.println("number of odd numbers: "+odd);
        System.out.println( "number of even numbers: "+ even);
        System.out.println("number of 0: "+ zero);

    }
}

