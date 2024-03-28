package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegNum {

    void negNumEachWin(int[] arr, int k)
    {
        int n= arr.length;
        Queue<Integer> qt = new LinkedList<>();
        int[] res = new int[n-k+1];

        for (int i=0;i<n;i++)
        {
            if (arr[i]<0)
                qt.add(i);
        }

        for (int i=0;i<=n-k;i++)
        {
            if (qt.size()>0 && qt.peek()<i)
                qt.remove();

            if (qt.size()>0 && qt.peek()<i+k)
            {
                res[i] = arr[qt.peek()];
            }
            else res[i] = 0;

        }

        for (int x:res)
            System.out.print(x+" ");
    }

    public static void main(String[] args) {

        int[] arr = {12, 1, -7, 8, 15, 30, 16, 28,-12,30};

        FirstNegNum obj = new FirstNegNum();

        obj.negNumEachWin(arr,3);


    }
}
