package SearchingSorting;
import java.util.*;

public class RedixSort {



    public static int maxOfArr(int[] arr) // Find maximum number of na array.
    {
        int max = arr[0];

        for (int i : arr)
            if (i>max)
                max=i;

        return max;
    }

    public static int[] freqArr(int[] arr, int place)// create frequency array of an Array.
    {
        int[] freqArray = new int[10];

        for(int x:arr)
            freqArray[(x/place)%10]++;

        return freqArray;
    }

    public static int[] prefixSum(int[] arr,int place) // create Prefix Sum array of an Array.
    {
        int[] preFixArr = freqArr(arr,place);

        for(int i=1;i<preFixArr.length;i++)
        {
            preFixArr[i]+=preFixArr[i-1];
        }

        return preFixArr;
    }

    public static void countSort(int[] arr,int place)
    {
        int[] preFixArr = prefixSum(arr,place);

        int[] sortArr = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--)
        {
            sortArr[preFixArr[(arr[i]/place)%10]-1]=arr[i];

            preFixArr[(arr[i]/place)%10]--;
        }

        int i=0;

        for(int t:sortArr)
        {
            arr[i++]=t;
        }

        // System.out.println(Arrays.toString(sortArr));
    }

    public static void redixSort(int[] arr)
    {
        // int place=1;
        int max = maxOfArr(arr);

        for(int place=1;max/place>0;place*=10)
        {
            countSort(arr,place);
        }
    }
    public static void main(String[] args) {

        int[] arr = {223,1036,5,58,2364,8693,5872478};

        redixSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
