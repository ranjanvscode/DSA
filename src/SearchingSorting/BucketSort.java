package SearchingSorting;

import java.util.*;

public class BucketSort {
    public static int maxOfArr(int[] arr) // Find maximum number of na array.
    {
        int max = arr[0];

        for (int i : arr)
            if (i>max)
                max=i;

        return max;
    }

    public static void bucketSort(int[] arr)
    {
        int max = maxOfArr(arr);
        int listLen = max/5+1;

        @SuppressWarnings("unchecked")
        // Initialize bucket array
        ArrayList<Integer>[] bucketArr = new ArrayList[listLen];

        for(int i=0;i<listLen;i++)
        {
            bucketArr[i] = new ArrayList<Integer>();
        }

        // Place elements into buckets
        for (int x:arr) {

            int idx = x/5;

            bucketArr[idx].add(x);
        }

        // Sort each bucket
        for (ArrayList list : bucketArr) {
            Collections.sort(list);
        }

        int indx = 0;

        // Merge buckets back to the original array
        for (ArrayList arrayList : bucketArr) {
            for (int j = 0; j < arrayList.size(); j++) {
                arr[indx++] = (int) arrayList.get(j);
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = {12,10,15,5,8,16,13,20,9,8,5,10,14};

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));

    }
    
}
