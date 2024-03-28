//Q2. WAP to sort an array in descending order using selection sort.

package SearchingSorting.Assignment1;

import java.util.Arrays;

public class Q2_SelectionSort {

    public static void main(String[] args) {

        int[] arr = {52,6,81,10,9,74,2,66,4,12,45,75,23,21,45,96,42};
        int l= arr.length;

        for (int i=0;i<l;i++) // Sorting
        {
            int max_idx = i;

            for (int j=i;j<l;j++) // Finding maximum value in array.
            {
                if (arr[max_idx]<arr[j])
                {
                    max_idx=j; //Storing Maximum value index.
                }
            }

            if (max_idx!=i) // Swapping value
            {
                int temp = arr[i];
                arr[i]=arr[max_idx];
                arr[max_idx] = temp;
            }

        }

        System.out.println(Arrays.toString(arr));// Printing
    }
}
