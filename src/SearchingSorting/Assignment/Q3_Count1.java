//Q3. Given a sorted binary array, efficiently count the total number of 1’s in it.

package SearchingSorting.Assignment;

public class Q3_Count1 {
    public static void main(String[] args) {

        int[] arr = {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1};//Sorted binary array
        int count=0;
        int l= arr.length;

        for (int i=l-1;i>=0;i--)// Counting
        {
            if (arr[i]==1)
                count++;
            else break;
        }

        System.out.println("Number of 1's in array: "+count);

    }
}
