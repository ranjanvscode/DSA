package SearchingSorting;
//Check that target value is available in rotated sorted array using binary search and array also contain duplicate value
public class BinarySearchQues {
    public static boolean binarySearch(int[] arr,int target) {

        int n=arr.length;

        int low=0;
        int high=n-1;

        while (low<=high) {

            int mid = low +(high-low)/2;

            if (arr[mid]==target) {

                return true;

            }else if(arr[low]==arr[mid] && arr[mid]==arr[high]) {

                low++;
                high--;

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

    // Question 1:
    //int[] arr2 = {5,2,3,4}; let's understand the question according to this array.
    //Total 4 chocolate ke dabbe hai aur har dabbe me kuchh chocolate hai.
    //Diye gye sabhi bachcho(num of student<=num of dabba) ke bich ye dabbe dene hai. kam se kam ek dabba ek bachche ko milna hi chahiye
    //Sabi dabbo ko respectively(kramshah) distribute karna hai. yadi sabhi bachcho ki alag alag tarike respectively grouping ki jaye to
    //har group me jo maximam hoga aur uss max me se jo min hoga wo batana hai?

    public static boolean maxChoco(int[] arr,int m,int maxChocolate){
        int person=1;
        int choco=0;

        for (int i=0;i< arr.length;i++)
        {
            if (arr[i]>maxChocolate) return false;

            if (choco+arr[i]<=maxChocolate){

                choco+=arr[i];

            }else {
                person++;
                choco=arr[i];
            }
        }

        return person<=m;
    }


    public static void minMaxChocolate(int[] arr,int m)
    {
        int st=0;
        int end=(int)1e9;
        int ans=0;

        if (arr.length<m) {
            System.out.println("Not Possible");
            return;
        }

        while (st<=end)
        {
            int mid=st+(end-st)/2;

            if (maxChoco(arr,m,mid)){
                ans=mid;
                end=mid-1;
            }else {
                st=mid+1;
            }
        }

        System.out.println(ans);
    }

    //Question-2:int[] arr = {1,3,5,7,10};let's understand the question according to this array.
    //Ek racetrack hai jisme arr me diye gye har KM ke baad ek baithne ki suvidha hai.
    //Pratyek seat par ek person baith sakta hai.
    //Sabhi person(num of person<=num of seat) ko iss prakar baithana hai ki unke bich max dist ho
    // Then what is the that max distance?

    public static boolean maxDistance(int[] arr,int m,int maxDist){

        int lastPerson=arr[0];
        int person=1;

        for (int i=1;i<arr.length;i++){

            if (arr[i]-lastPerson>=maxDist){
                lastPerson=arr[i];
                person++;
            }
        }

        return person>=m;
    }

    public static int searchMaxDist(int[] arr,int m){
        int st=1;
        int end=(int)1e9;
        int ans=0;

        if (arr.length<m) return -1;

        while (st<=end){
            int mid=st+(end-st)/2;

            if (maxDistance(arr,m,mid)){
                ans=mid;
                st=mid+1;
            }else {
                end=mid-1;
            }
        }

        return ans;
    }



    public static void main(String[] args) {

//        int[] arr = {5,6,7,7,7,8,9,9,9,9,0,1,2,2,3,3,3,3,4,4,5};

//        System.out.println(binarySearch(arr,15));

//        int[] arr2 = {1,2,3};
        int[] arr = {1,3,5,7,10};
        int m=5;// Number of person.
//        minMaxChocolate(arr,m);
        System.out.println(searchMaxDist(arr,m));
    }

}
