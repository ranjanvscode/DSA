package SearchingSorting.Assignment;

import java.util.Scanner;

public class Q4_CountDuplicate {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int count=0;

        System.out.println("Enter target number:");
        int tar  = sc.nextInt();

        for (int x:nums)
        {
            if (x==tar)
                count++;

            else if (x>tar)
                break;
        }

        System.out.println("Target "+tar+" occurs "+count+" times.");

    }
}
