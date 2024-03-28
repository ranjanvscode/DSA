package SearchingSorting.Assignment1;

import java.util.Arrays;

public class Q3_InsertionSort {
    public static void main(String[] args) {

        int[] arr = {3,5,1,6,0};
        int l= arr.length;

        for (int i=0;i<l;i++)
        {
            int j=i;
            while (j>0 && arr[j-1]<arr[j])
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
