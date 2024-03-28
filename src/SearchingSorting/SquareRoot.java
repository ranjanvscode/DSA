//Find the square root or flour value of square root in rotated sorted array using binary search.
package SearchingSorting;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // Array must be sorted.

        int low = 0;
        int high = arr.length-1;
        int mid=0,non=-1,result=0;

        System.out.println("Enter target no.");
        int target=sc.nextInt();

        if (target > arr[high]*arr[high])
        {
            non=-2;
            System.out.println("Entered number is out of range.");
        }

        while (low<=high)
        {
            if (non==-2) break;

            mid = low + (high-low)/2;

            int sqr = arr[mid] * arr[mid];

            if (sqr == target)
            {
                non=1;
                break;
            } else if (sqr < target) {
                result = mid;
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        if (non==1){
            System.out.println("Square Root = "+arr[mid]);
        }else if (non==-1){
            System.out.println("Square root(Floor Value) = " + arr[result]);
        }
    }
}
