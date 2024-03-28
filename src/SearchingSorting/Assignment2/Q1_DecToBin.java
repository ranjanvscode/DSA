// Q1. Given a number, print its binary representation.

package SearchingSorting.Assignment2;

import java.util.Scanner;

public class Q1_DecToBin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Decimal number:");
        int num= sc.nextInt();

        int r,t=1,binary=0;

        while(num!=0)
        {
            r=num%2;
            binary += r*t;
            t*=10;
            num=num/2;
        }

        System.out.println("Binary number= "+binary);
    }
}
