package SearchingSorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {52,6,81,10,9,74,2,66,4,12,45,75,23,21,45,96,42};
        int l= arr.length;

        for (int i=0;i<l;i++) // Sorting
        {
            int min_idx = i;

            for (int j=i;j<l;j++) // Finding minimum value in array.
            {
                if (arr[min_idx]>arr[j])
                {
                    min_idx=j; //Storing minimum value index.
                }
            }

            if (min_idx!=i) // Swapping value
            {
                int temp = arr[i];
                arr[i]=arr[min_idx];
                arr[min_idx] = temp;
            }

        }

        System.out.println(Arrays.toString(arr));// Printing
    }
}
