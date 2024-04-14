package BinarySearchTree;

import java.util.*;

public class BST_BasicQues {

    static int x;
    static Node pre;
    static Node suc;

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

    static void preOrder(Node root)
    {
        if (root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static Node search(Node root,int target)
    {
        if (root==null) return null;

        if (target==root.val) return root;
        if (target < root.val) return search(root.left,target);
        else return search(root.right,target);
    }

    static void insertInBST(Node root,int element)
    {
        if (element<root.val)
        {
            if (root.left==null) root.left = new Node(element);
            else insertInBST(root.left,element);
        }else {
            if (root.right==null)  root.right = new Node(element);
            else insertInBST(root.right,element);
        }
    }

    static void levelOrderTraversal(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            Node temp = q.remove();

            System.out.print(temp.val+" ");

            if (temp.left!=null) q.add(temp.left);
            if (temp.right!=null) q.add(temp.right);
        }
    }

    static void deletionInBST(Node root,int target)
    {
        if(root==null) return;
        if (target<root.val)
        {
            if (root.left.val==target)
            {
                Node curr = root.left;
                if (curr.left==null && curr.right==null) root.left = null;
                else if (curr.left==null || curr.right==null)
                {
                    if (curr.left==null) root.left = curr.right;
                    else root.left = curr.left;
                }else { //2 Child

                    Node pred = curr.left;
                    while (pred.right!=null) pred = pred.right;
                    deletionInBST(root,pred.val);
                    curr.val = pred.val;
                }
            }else deletionInBST(root.left,target);
        }else {
            if (root.right.val==target)
            {
                Node curr = root.right;
                if (curr.left==null && curr.right==null) root.right = null;
                else if (curr.left==null || curr.right==null)
                {
                    if (curr.left==null)root.right = curr.right;
                    else root.right = curr.left;
                }else { //2 Child

                    Node pred = curr.left;
                    while (pred.right!=null) pred = pred.right;
                    deletionInBST(root,pred.val);
                    curr.val = pred.val;
                }
            }else deletionInBST(root.right,target);
        }
    }

    static Node lowestCommonAncestor(Node root,int p,int q)
    {
        if (p<root.val && q<root.val) return lowestCommonAncestor(root.left,p,q);
        else if (p>root.val && q>root.val) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }

    static void validBST(Node root)
    {

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

    static void kthSmallestNum(Node root,int k)
    {
        if (root==null) return;
        kthSmallestNum(root.left,k);
            x--;//Global variable;
            if (x==0) System.out.println(root.val);
        kthSmallestNum(root.right,k);

    }

    static void constructBSTFromLinkedList(){
        //Convert linkedlist into array.
        //then create tree
    }

    static void findPreSuc(Node root, int val)
    {

        // Base case
        if (root == null)
            return;

        // If key is present at root
        if (root.val == val)
        {

            // The maximum value in left
            // subtree is predecessor
            if (root.left != null)
            {
                Node tmp = root.left;
                while (tmp.right != null)
                    tmp = tmp.right;

                pre = tmp;
            }

            // The minimum value in
            // right subtree is successor
            if (root.right != null)
            {
                Node tmp = root.right;

                while (tmp.left != null)
                    tmp = tmp.left;

                suc = tmp;
            }
            return;
        }

        if (root.val > val)
        {
            suc = root;
            findPreSuc(root.left, val);
        }
        else
        {
            pre = root;
            findPreSuc(root.right, val);
        }
    }

    public static void main(String[] args) {

        int[] arr = {2,5,6,8,10,12,15,20,25,27,31,32,35,40,43,45};
        List<Integer> list = new ArrayList<>();

        Node root = constructBST(arr,0, arr.length-1);
//        levelOrderTraversal(root);
//        System.out.println();
//        preOrder(root);
//        x=10;//kth place
//        kthSmallestNum(root,x);



    }
}
