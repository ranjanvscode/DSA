// Q5: Given a positive integer num, return true if num is a perfect square or false otherwise.

package SearchingSorting.Assignment;

import java.util.Scanner;

public class Q5_PerfectSquare {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int num = sc.nextInt();

        int result = (int)Math.sqrt(num);

        if (result*result == num)
             System.out.println("True");
        else
             System.out.println("False");

    }
}
