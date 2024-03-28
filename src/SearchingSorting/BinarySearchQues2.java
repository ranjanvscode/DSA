package SearchingSorting;
//Check that target value is available in rotated sorted array using binary search
public class BinarySearchQues2 {
    public static boolean binarySearch(int[] arr,int target) {

        int n=arr.length;

        int low=0;
        int high=n-1;

        while (low<=high) {

            int mid = low +(high-low)/2;

            if (arr[mid]==target) {

                return true;

            }else if(arr[mid]<=arr[high]){

                if (arr[mid]<target && target<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
            else if(arr[low]<=arr[mid]){

                if (arr[low]<=target && target<arr[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {7,8,9,10,11,12,13,14,15,0,1,2,3,4,5,6};

        System.out.println(binarySearch(arr,15));
    }
}
