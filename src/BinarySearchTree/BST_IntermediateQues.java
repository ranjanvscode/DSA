package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST_IntermediateQues {

    static int sum = 0;
    static int min = Integer.MAX_VALUE;
    static Node prev = null;
    static class Node
    {
        int val;
        Node right;
        Node left;
        Node(){}
        Node(int val)
        {
            this.val = val;
        }
    }
    static Node constructBST(int[] arr,int low,int high)
    {
        if (low>high) return null;
        int mid = (low+high)/2;
        Node node = new Node(arr[mid]);
        node.left = constructBST(arr,low,mid-1);
        node.right = constructBST(arr,mid+1,high);

        return node;
    }

    static void inorder(Node root)
    {
        if (root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static void convertIntoGreaterBSTTree(Node root)
    {
        if (root==null) return;

        //You can avoid global variable sum using sum array of 1 size and pass in agrs.
        convertIntoGreaterBSTTree(root.right);
        root.val = root.val + sum;
        sum = root.val;
        convertIntoGreaterBSTTree(root.left);

    }

    static void minDiffOfTwoNodes(Node root)
    {
        if(root==null) return;

        minDiffOfTwoNodes(root.left);

        if (prev!=null)
        {
            int diff = Math.abs(root.val- prev.val);
            min = Math.min(diff,min);
        }

        prev = root;

        minDiffOfTwoNodes(root.right);
    }

    //Morris traversal and Time Complexity  = O(n)
    static void morrisTraversal(Node root)
    {
        Node curr = root;
        Node pred = null;

        while (curr!=null)
        {
            if(curr.left!=null)
            {
                pred = curr.left;

                while (pred.right!=null && pred.right!=curr)
                {
                    pred = pred.right;
                }

                if (pred.right==null)
                {
                    pred.right = curr;
                    curr = curr.left;
                }

                if (pred.right==curr)
                {
                    pred.right = null;
                    System.out.print(curr.val+" ");
                    curr = curr.right;
                }
            }
            else
            {
                System.out.print(curr.val+" ");
                curr = curr.right;
            }
        }
    }

    static void mergeTwoBST()
    {

    }

    public static void trimHelper(Node root, int low, int high)
    {
        if(root==null) return;

        while(root.left!=null)
        {
            if(root.left.val<low) root.left = root.left.right;
            else  if(root.left.val>high) root.left = root.left.left;
            else break;
        }

        while(root.right!=null)
        {
            if(root.right.val<low) root.right = root.right.right;
            else  if(root.right.val>high) root.right = root.right.left;
            else break;
        }
        trimHelper(root.left,low,high);
        trimHelper(root.right,low,high);
    }
    static void trimBST(Node root, int low, int high) {

        Node dumyNode  = new Node(Integer.MAX_VALUE);

        dumyNode.left = root;

        trimHelper(dumyNode,low,high);

    }

    /*use morris traversal and add some logics
    1 2 6 4 5 3 7.
        p     c   -> swap prev & curr
    */
    static void recoverBST(Node root)
    {
        Node curr = root;
        Node prev = null;

        Node pred = null;

        Node first = null;
        Node second = null;

        while (curr!=null)
        {
            if(curr.left!=null)
            {
                pred = curr.left;

                while (pred.right!=null && pred.right!=curr) pred = pred.right;

                if (pred.right==null)
                {
                    pred.right = curr;
                    curr = curr.left;
                }

                if (pred.right==curr)
                {
                    pred.right = null;

                    if (prev != null && prev.val > curr.val)
                    {
                        if (first == null) first = prev;

                        second = curr;
                    }
                    prev = curr;

                    curr = curr.right;
                }
            }
            else
            {
                if (prev != null && prev.val > curr.val)
                {
                    if (first == null) first = prev;

                    second = curr;
                }
                prev = curr;

                curr = curr.right;
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 8, 10, 12, 15, 20, 25, 27, 31, 32, 35, 40, 43, 45};

        Node root  = constructBST(arr,0, arr.length-1);

//        inorder(root);
//        convertIntoGreaterBSTTree(root);
//        System.out.println();
//        inorder(root);

//        TreeNode.SNode root  = TreeNode.constructBST(arr,0, arr.length-1);

//        trimBST(root,10,30);
//        morrisTraversal(root);

        recoverBST(root);

    }
}
