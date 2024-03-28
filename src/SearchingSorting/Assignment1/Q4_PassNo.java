package SearchingSorting.Assignment1;

// a bubble sort required only n-1 pass;
// in {3,5,1,6,0} required only 4 pass;

import java.util.Arrays;

public class Q4_PassNo {
    public static void main(String[] args) {
        int[] arr = {3,5,1,6,0};
        int l= arr.length,count=0;


        for (int i=0;i<l;i++)
        {
            boolean sw = false;

            for (int j=1;j<l-i;j++)
            {
                if (arr[j-1]<arr[j])
                {
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                    sw=true;
                    count++;
                }
            }

            if (!sw)
            {
                break;
            }

        }

        System.out.println(Arrays.toString(arr));

        // in {3,5,1,6,0} required only 4 pass;
        System.out.println("\nNumber of passes: "+count);
    }
}