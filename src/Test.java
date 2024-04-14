import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test
{


    public static void main(String[] args) {

        int n = (int) 1e6;
        int[] arr = new int[n];

        arr[0] = 5;
        arr[1] = 5;
        arr[2] = 5;
        arr[3] = 5;

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
            if (arr[i]==0) break;
        }

    }
}