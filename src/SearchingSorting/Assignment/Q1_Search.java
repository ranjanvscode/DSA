// Q1. Given an array. FInd the number X in the array. If the element is present, return the index of the element,
//     else print “Element not found in array”. Input the size of array, array from user and the element X from user.
//     Use Linear Search to find the element.

package SearchingSorting.Assignment;

import java.util.Scanner;

public class Q1_Search {
    public static int search(int[] arr, int tar)
    {
        for (int i=0;i< arr.length;i++)
        {
            if (arr[i]==tar)
            {
                return i;
            }
        }
        return -1;
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
            System.out.println("Element is found in array at index "+result+".");
        }
        else {
            System.out.println("Element is not found in array.");
        }

    }
}
