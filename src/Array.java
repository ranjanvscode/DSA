import java.util.Scanner;

class ranjan{
    static void print(int[] arr)
    {
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+ " ");
        }
    }

    static void prefixsum(int[] arr)
    {
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
          arr[i]+=arr[i-1];
        }
    }

    static void custumprefixsum(int[] arr,int start,int end)//must call prefixsum before call this.
    {
        int sum=0;
        if (start==1)
        {sum=arr[end-1];}
        else {sum=arr[end-1]-arr[start-2];}
        System.out.println("Sum="+sum);
    }

    static void sort(int[] arr)
    {
        int length = arr.length;

        for (int j = 0; j < length - 1; j++) {

            if (arr[j] > arr[j + 1]) {

                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                j = -1;
            }
        }
    }

    static void reverse(int[] arr)
    {
        int length = arr.length;

        for (int j = 0; j < length - 1; j++) {

            if (arr[j] < arr[j + 1]) {

                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;

                j = -1;
            }
        }
    }

    static int[] freqArray(int[] arr)
    {
        int[] freq = new int[100005];
        int n= arr.length;
        for (int i=0;i<n;i++)
        {
            freq[arr[i]]+=1;
        }
        return freq;
    }

    static void search(int[] arr , int target)
    {

        if(arr[target]>0)
        {
            System.out.println("Yes! "+target+" is present in array.");
        }else {
            System.out.println("No! "+target+" is not present in array.");
        }
    }
    static int totalsumarr(int[] arr)
    {
        int totalsum=0;
        int n= arr.length;
        for(int i=0;i<n;i++)
        {
            totalsum+=arr[i];
        }
        return totalsum;
    }

    static boolean presuf(int[] arr)
    {
        int n= arr.length;
        int total=totalsumarr(arr);
        int psum=0,ssum=0;
        for(int i=0;i<n;i++)
        {
           psum+=arr[i];
           ssum=total-psum;
           if(psum==ssum)
           {
               return true;
           }
        }
        return false;
    }

    static void sideanynumber(int [] arr)
    {
        int n = arr.length;
        for (int i=0,j=0;i<n;i++)
        {

            if (arr[j]==0 && arr[i]!=0)
            {
                arr[j]=arr[i];
                arr[i]=0;
            }
            if (arr[j]!=0)
            {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[] arr ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//        int [] arr = {12,15,10,8,16,13,11,12,5,6,7,1,8,3,10};
//        int[] arr3={1,4,22,7,5,15};
//        int[] arr={5,2,6,3,8,1,9,10,12};

    }
}