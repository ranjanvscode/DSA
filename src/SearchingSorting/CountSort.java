package SearchingSorting;
import java.util.*;

public class CountSort {


    public static int maxOfArr(int[] arr) // Find maximum number of na array.
    {
        int max = arr[0];

        for (int i : arr)
            if (i>max)
                max=i;

        return max;
    }

    public static int[] freqArr(int[] arr)// create frequency array of an Array.
    {
        int[] freqArray = new int[maxOfArr(arr)+1];

        for(int x:arr)
            freqArray[x]++;

        return freqArray;
    }

    public static int[] prefixSum(int[] arr) // create Prefix Sum array of an Array.
    {
        int[] preFixArr = freqArr(arr);

        for(int i=1;i<preFixArr.length;i++)
        {
            preFixArr[i]+=preFixArr[i-1];
        }

        return preFixArr;
    }

    // Place all num in ascending order with stable sorting
    public static void countSort(int[] arr)
    {
        int[] preFixArr = prefixSum(arr);

        int[] sortArr = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--)
        {
            sortArr[preFixArr[arr[i]]-1]=arr[i];

            preFixArr[arr[i]]--;
        }

//        int i=0;
//
//        for(int t:sortArr)
//        {
//            arr[i++]=t;
//        }

         System.out.println(Arrays.toString(sortArr));
    }

    public static void main(String[] args) {

        int[] arr = {0,1,0,2,0,1,1,0,2,1,0,2,1,0,1,1};

        countSort(arr);

//        System.out.println(Arrays.toString(arr));

    }
}
