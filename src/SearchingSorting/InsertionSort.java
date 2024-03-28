package SearchingSorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {52,6,81,10,9,74,2,66,4,12,45,75,23,21,45,96,42};
        int l= arr.length;

        for (int i=0;i<l;i++)
        {
            int j=i;
            while (j>0 && arr[j-1]>arr[j])
            {
                int temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;

                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
