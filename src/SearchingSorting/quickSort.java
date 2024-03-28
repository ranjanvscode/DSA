package SearchingSorting;

import java.util.*;

// This quick sort is not a stable sorting.

public class quickSort {

    public static void swap(int[] arr,int idx1, int idx2)
    {
        int temp = arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }

    public static int partition(int[] arr,int st,int end)
    {
        int pIdx=st;   // Pivot number index.
        int count=0;

        for (int x=st+1;x<=end;x++) {
            if (arr[x]<=arr[pIdx])
                count++;
        }

        pIdx = st+count;

        swap(arr, st, pIdx); //

        int i=st,j=end;

        while (i<pIdx && j>pIdx) { // Arranging smaller in left and larger in right.

            while (arr[i]<=arr[pIdx]) i++;

            while (arr[j]>arr[pIdx]) j--;

            if (i<pIdx && j>pIdx)
            {
                swap(arr, i, j);
                i++;
                j--;
            }

        }

        return pIdx;
    }

    public static void quickSort(int[] arr, int st, int end)
    {
        if (st>=end) {
            return;
        }

        int pIdx = partition(arr,st,end);

        quickSort(arr, st, pIdx-1);
        quickSort(arr, pIdx+1, end);

    }

    public static void main(String[] args) {

        int[] arr = {5,6,3,8,10,2,5,3,3,5,5,9,8,3,1,9,4,7,2};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
