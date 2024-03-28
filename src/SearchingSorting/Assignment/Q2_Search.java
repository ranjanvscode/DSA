// Q2. Given an array and an integer “target”, return the last occurrence of
//     “target” in the array. If the target is not present return -1.

package SearchingSorting.Assignment;

import java.util.Scanner;

public class Q2_Search {
    public static int search(int[] arr, int tar)
    {
        int pres = -1;

        for (int i=0;i< arr.length;i++)
        {
            if (arr[i]==tar)
            {
                pres = i;
            }
        }

        return pres;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of array:");
        int num = sc.nextInt();

        int[] arr = new int[num];

        System.out.println("Enter element in array:");

        for (int i=0;i< arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter Target Number:");
        int tar = sc.nextInt();

        int result = search(arr,tar);

        if (result>-1)
        {
            System.out.println("The last occurrence of element is found in array at index "+result+".");
        }
        else {
            System.out.println("Target element is not present in array.");
        }

    }
}
