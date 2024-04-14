package BinaryTrees;

public class TreeNode {

    public static class SNode{
        int val;
        SNode left;
        SNode right;

        SNode(){}
        SNode(int val)
        {
            this.val = val;
        }
    }

    public static SNode constructBST(int[] arr,int low,int high)
    {
        if (low>high) return null;
        int mid = (low+high)/2;
        SNode node = new SNode(arr[mid]);
        node.left = constructBST(arr,low,mid-1);
        node.right = constructBST(arr,mid+1,high);

        return node;
    }
}
