package DSA_Arrays;

class ArrayMethod
{
    public static void display(int[] arr)
    {
        int l= arr.length;
        for (int i=0;i<l;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void Palindrome(int[] arr)
    {
        int l= arr.length,f=0;
        for (int i=0;i<l/2;i++)
        {
            if (arr[i]!=arr[l-1-i])
            {
                f=-1;
                break;
            }
        }

        if (f==0)
        {
            System.out.println("Array is Palindrome");
        }
        else
        {
            System.out.println("Array is not Palindrome");
        }
    }
    public static void Reversal(int[] arr)
    {
        int s,l=arr.length;
        for (int i=0;i<l/2;i++)
        {
            s=arr[i];
            arr[i] = arr[l-1-i];
            arr[l-1-i] = s;
        }
    }
    public static void MissingNo(int[] arr)
    {
        int len = arr.length;
        int num=arr[0];
        for (int i=0;i<len;i++)
        {
            if(num!=arr[i])
            {
                i--;
                System.out.println("Missing No.:"+num);
            }
            num+=1;
        }
    }

    public static void sumOfEvenIndicesEle(int[] arr)
    {
        int l= arr.length,sum=0;
        for (int i=0;i<l;i++)
        {
            if (i%2==0)
            {
                sum+=arr[i];
            }
        }
        System.out.println("Sum of even indices element: "+sum);
    }

    public static void printEvenEle(int[] arr)
    {
        for (int a : arr)
        {
            if (a%2 == 0){
                System.out.println(a+" ");
            }
        }
    }

    public static void maxEle(int[] arr)
    {
        int max=arr[0];
        for (int x : arr) {
            if (x>max)
            {
                max=x;
            }
        }
        System.out.println("Maximum Number: "+max);
    }

    public static void secMaxEle(int[] arr)
    {
        int max=arr[0],secMax = 0;
        for (int j : arr) {
            if (j>max)
            {
                secMax = max;
                max = j;
            }

            if (j<max && j>secMax)
            {
                secMax = j;
            }
        }
        System.out.println("Second Maximum Number: " + secMax);
    }

    public static void peakEle(int [] arr)
    {
        int num= -10000;
        for (int i=1;i< arr.length-1;i++)
        {
            if (arr[i-1]<arr[i] && arr[i]>arr[i+1])
            {
                if (arr[i]>num)
                {
                    num=arr[i];
                }
            }
        }
        System.out.println("First Peak Element: "+ num);
    }

}

public class Array1D {

    public static void main(String[] args)
    {
        int[] arr3 = {1,3,2,6,5};
        ArrayMethod.peakEle(arr3);


    }
}
