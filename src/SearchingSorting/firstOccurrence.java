package SearchingSorting;

public class firstOccurrence {

    public static void swap(int[] arr,int a,int b )
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }

    //  This sort only 0,1 and 2. Array should be like {0,1,2,0,1,0,0,1,1,0,2,2,1,0,2}
    public static void sort012(int[] arr)
    {
        int low=0;
        int mid=0;
        int high=arr.length-1;

        while (mid<high) {

            if (arr[mid]==0) {
                swap(arr, mid, low);
                mid++;
                low++;
            }else if (arr[mid]==2) {
                swap(arr, mid, high);
                high--;
            }else{
                mid++;
            }
        }
    }

    //It finds the index of first or last occurrence of target.
    public static void firstAndLastOcc(int[] arr, int target)
    {
        int low=0;
        int high= arr.length-1;
        int mid=low+(high-low)/2;
        int res=-1;

        while (low<=high)
        {
            mid=low+(high-low)/2;

            if (arr[mid]==target)
            {
                res=mid;
                high=mid-1; // First occurrence
//                low=mid+1; // Last occurrence
            } else if (arr[mid] < target) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }

        System.out.println("First Occurrence: "+res);

    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,3,5,5,5,5,5,6,6,6,7,7,7,8,9,9,9,10};

        int target=6;
        firstAndLastOcc(arr,target);
    }
}
