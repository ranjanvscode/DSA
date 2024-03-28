package SearchingSorting;

public class MergeSort {

    static void merge(int[] arr,int l,int mid,int r)
    {
        int n1=mid-l+1;
        int n2=r-mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        int i,j,k;

        for(i=0;i<n1;i++) arr1[i] = arr[l+i];
        for(i=0;i<n2;i++) arr2[i] = arr[mid+i+1];
        i=0;j=0;k=l;

        while (i<n1 && j<n2) {

            if (arr1[i]<=arr2[j])
                arr[k++]=arr1[i++];
            else
                arr[k++]=arr2[j++];
        }

        while (i<n1)
            arr[k++]=arr1[i++];

        while (j<n2)
            arr[k++]=arr2[j++];
    }

    static void mergeSort(int[] arr,int l,int r)
    {
        if (l>=r) {
            return;
        }

        int mid=(l+r)/2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        merge(arr,l,mid,r);
    }

    public static void main(String[] args) {

        int[] arr = {2,5,6,8,1,9,3,4,7,1};

        mergeSort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
}
