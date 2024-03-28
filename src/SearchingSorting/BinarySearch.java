package SearchingSorting;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,10}; // Array must be in sorted form.

        int low = 0;
        int high = arr.length-1;
        int mid=0,non=-1;

        System.out.println("Enter target no.");
        int target=sc.nextInt();

        while (low<=high)
        {
            mid = low + (high-low)/2;

            if (arr[mid]==target)
            {
                non=1;
                break;
            } else if (arr[mid] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }

        if (non==1){
            System.out.println("Index No.- "+mid);
        }else {
            System.out.println("Number is not present in the list.");
        }
    }
}
