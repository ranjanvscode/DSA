package BinaryTrees;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;


public class BS_AdvancedQues {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(){}
        Node(int val)
        {
            this.val = val;
        }
    }

    static Node createBinaryTree(String[] arr)
    {
        if (arr[0].isEmpty()) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(arr[0]));
        q.add(root);
        int n= arr.length;
        int i=1;

        while (i<n-1)
        {
            Node left = new Node();
            Node right = new Node();
            Node temp = q.remove();

            int l,r;
            if (!arr[i].isEmpty())
            {
                l = Integer.parseInt(arr[i]);
                left.val=l;
                temp.left = left;
                q.add(left);
            }

            if (!arr[i+1].isEmpty())
            {
                r = Integer.parseInt(arr[i+1]);
                right.val = r;
                temp.right = right;
                q.add(right);
            }
            i+=2;
        }

//        levelTraversal(root);
//        System.out.println(contains(root,6).right.val);
        return root;
    }

    static void flattenBinaryTree(Node root)
    {
        Node curr = root;

        while (curr!=null)
        {
            Node leftTree = curr.left;

            if (leftTree!=null)
            {
                while (leftTree.right!=null)
                {
                    leftTree = leftTree.right;
                }

                leftTree.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }

        printLinkedList(root);
    }


   static void flattenBinaryTreeRecursively(Node root)
    {
        if (root==null) return;

        flattenBinaryTreeRecursively(root.left);
        flattenBinaryTreeRecursively(root.right);

        Node leftTree = root.left;
        Node rightTree = root.right;

        root.left = null;
        root.right = leftTree;

        while (leftTree!=null && leftTree.right!=null)
        {
            leftTree = leftTree.right;
        }

        if (leftTree!=null)
        {
            leftTree.right = rightTree;
        }
    }
    private static void printLinkedList(Node root) {

        Node temp = root;

        while (temp!=null)
        {
            System.out.print(temp.val+" ");
            temp = temp.right;
        }
    }

    static void preorder(Node root)
    {
        if(root==null) return;

        preorder(root.left);
        System.out.print(root.val+" ");
        preorder(root.right);
    }

    static Node findSNode(Node root,int start)
    {
        if (root==null) return null;
        if (root.val==start) return root;
        Node lNode = findSNode(root.left,start);
        Node rnode = findSNode(root.right,start);
        if (lNode!=null) return lNode;
        return rnode;
    }

    static void parent(Node root, HashMap<Node,Node> p)
    {
        if (root==null) return;

        if (root.left!=null) p.put(root.left,root);
        if (root.right!=null) p.put(root.right,root);

        parent(root.left,p);
        parent(root.right,p);
    }
    static void infectedBinaryTree(Node root,int start)//Leetcode - 2385
    {
        Node snode = findSNode(root,start);
        HashMap<Node,Integer> v = new HashMap<>();
        HashMap<Node,Node> p = new HashMap<>();
        parent(root,p);
        Queue<Node> q = new LinkedList<>();

        q.add(snode);
        v.put(snode,0);

        while (!q.isEmpty())
        {
            Node temp = q.remove();
            int level = v.get(temp);

            if (temp.left!=null && !v.containsKey(temp.left))
            {
                q.add(temp.left);
                v.put(temp.left,level+1);
            }

            if (temp.right!=null && !v.containsKey(temp.right))
            {
                q.add(temp.right);
                v.put(temp.right,level+1);
            }

            if (p.containsKey(temp) && !v.containsKey(p.get(temp)))
            {
                q.add(p.get(temp));
                v.put(p.get(temp),level+1);
            }
        }

        int max = -1;
        for (int num:v.values())
        {
            if (num>max) max=num;
        }

        System.out.println(max);
    }

    public static void main(String[] args) {

        String[] arr = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

        Node root = createBinaryTree(arr);

//        preorder(root);

        infectedBinaryTree(root,6);




    }
}
