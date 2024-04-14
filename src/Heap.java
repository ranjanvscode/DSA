import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class Heap {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        list.add(6);
//        list.add(7);
//        list.add(12);
//        list.add(10);
//        list.add(15);
//        list.add(17);
//        list.add(20);

        list.add(20);
        list.add(17);
        list.add(15);
        list.add(10);
        list.add(12);
        list.add(7);
        list.add(6);

//        int[] arr = {5,3,9,4,8,6,15,10,12,20,7,2,13,1,11};
//        int[] arr = {1, 4, 2, 5, 7, 6, 3, 10, 12, 20, 8, 9, 13, 15, 11};

        System.out.println(list+"\n");
//        int num = 20;
//        insertInMinHeap(list,num);
//        insertInMaxHeap(list,num);

        deleteInMaxHeap(list);
        System.out.println(list);
    }

    private static void deleteInMinHeap(List<Integer> list) {
        swap(list,0,list.size()-1);
        list.remove(list.size()-1);

        pushDownInMinHeap(list,0);
    }

    private static void pushDownInMinHeap(List<Integer> list, int idx) {
        int n = list.size()-1;

        int smallest = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        if (idx==n) return;

        if (left<=n && list.get(left)<list.get(smallest)) smallest = left;

        if (right<=n && list.get(right)<list.get(smallest)) smallest = right;

        if (smallest==idx) return;

        swap(list,idx,smallest);
        pushDownInMinHeap(list,smallest);
    }

    private static void deleteInMaxHeap(List<Integer> list) {
        swap(list,0,list.size()-1);
        list.remove(list.size()-1);

        pushDownInMaxHeap(list,0);
    }

    private static void pushDownInMaxHeap(List<Integer> list, int idx) {
        int n = list.size()-1;

        int largest = idx;
        int left = 2*idx+1;
        int right = 2*idx+2;

        if (idx==n) return;

        if (left<=n && list.get(left)>list.get(largest)) largest = left;

        if (right<=n && list.get(right)>list.get(largest)) largest = right;

        if (largest==idx) return;

        swap(list,idx,largest);
        pushDownInMaxHeap(list,largest);
    }

    private static void insertInMinHeap(List<Integer> list, int num) {

        int idx = list.size();
        list.add(num);
        pushUpInMinHeap(list,idx);

    }

    private static void pushUpInMinHeap(List<Integer> list, int idx) {

        int idxOfParent = (idx-1)/2;

        if(idx==0 || list.get(idx)>=list.get(idxOfParent)) return;

        swap(list,idx,idxOfParent);

        pushUpInMinHeap(list,idxOfParent);
    }

    private static void insertInMaxHeap(List<Integer> list, int num) {

        int idx = list.size();
        list.add(num);
        pushUpInMaxHeap(list,idx);

    }

    private static void pushUpInMaxHeap(List<Integer> list, int idx) {

        int idxOfParent = (idx-1)/2;

        if(idx==0 || list.get(idx)<=list.get(idxOfParent)) return;

        swap(list,idx,idxOfParent);

        pushUpInMaxHeap(list,idxOfParent);
    }
}
