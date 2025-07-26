package SearchingSorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {52,6,81,10,9,74,2,66,4,12,45,75,23,21,45,96,42};
        int l= arr.length;

        for (int i=1;i<l;i++)
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

//            for (int i = 1; i < arr.length; i++) {
//                int key = arr[i];
//                int j = i - 1;
//
//                while (j >= 0 && arr[j] > key) {
//                    arr[j + 1] = arr[j];
//                    j--;
//                }
//                arr[j + 1] = key;
//            }


        System.out.println(Arrays.toString(arr));
    }
}
