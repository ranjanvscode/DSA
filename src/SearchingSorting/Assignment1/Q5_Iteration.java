package SearchingSorting.Assignment1;

//Q2. WAP to sort an array in descending order using selection sort.

import java.util.Arrays;

public class Q5_Iteration {

    public static void main(String[] args) {

        int[] arr = {3,5,1,6,0};
        int l= arr.length,count=0;

        for (int i=0;i<l;i++) // Sorting
        {
            int max_idx = i;

            for (int j=i;j<l;j++) // Finding maximum value in array.
            {
                if (arr[max_idx]<arr[j])
                {
                    max_idx=j; //Storing Maximum value index.
                }
                count++;
            }

            if (max_idx!=i) // Swapping value
            {
                int temp = arr[i];
                arr[i]=arr[max_idx];
                arr[max_idx] = temp;
            }

        }

        System.out.println(Arrays.toString(arr));// Printing

        System.out.println("\nNumber of iteration to sort an array: "+count);
    }
}

