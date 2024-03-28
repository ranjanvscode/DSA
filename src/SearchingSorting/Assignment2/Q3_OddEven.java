package SearchingSorting.Assignment2;

import java.util.Scanner;

public class Q3_OddEven {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number:");
            int num= sc.nextInt();

            if ((num & 1) == 0) {
                System.out.println(num + " is even");
            } else {
                System.out.println(num + " is odd");
            }
        }
    }

