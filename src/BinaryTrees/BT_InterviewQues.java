package BinaryTrees;

import java.util.*;

public class BT_InterviewQues {

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

    static void preorder(Node root)
    {
        if(root==null) return;

        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void invertTree(Node root)
    {
        if (root==null) return;
        if (root.left==null && root.right==null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }

    static boolean balanceTree(Node p,Node q)
    {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val!=q.val) return false;

        return balanceTree(p.left,q.left) && balanceTree(p.left,q.left);
    }

    static boolean symmetricTree(Node root){
          invertTree(root.left);

          return balanceTree(root.left,root.right);
    }

    static void levelTraversal(Node root)
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
    static void BT_Zigzag_Printing(Node root)
    {
        if (root==null) return;
        Queue<Node> q = new LinkedList<>();
        Stack<Node> stc = new Stack<>();
        stc.add(root);
        int i=1;

        System.out.print(root.val+" ");

        while (!stc.isEmpty())
        {
            while (!stc.isEmpty())
            {
                Node temp = stc.pop();

                if (i%2!=0){
                    if (temp.right!=null)
                        q.add(temp.right);

                    if (temp.left!=null)
                        q.add(temp.left);
                }else {
                    if (temp.left!=null)
                        q.add(temp.left);

                    if (temp.right!=null)
                        q.add(temp.right);
                }
            }
            i++;

            while (!q.isEmpty())
            {
                Node help = q.remove();
                stc.add(help);
                System.out.print(help.val+" ");
            }
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

    static Node contains(Node root,int target)
    {
        if (root==null) return null;
        if (root.val==target) return root;

        Node l = contains(root.left,target);
        Node r = contains(root.right,target);

        if (l!=null) return l;
        return r;
    }

    static void leftNode(Node root){
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        System.out.print(root.val+" ");
        if (root.left!=null) leftNode(root.left);
        else leftNode(root.right);
    }

    static void leafNode(Node root)
    {
        if (root==null) return;
        if (root.left==null && root.right==null)
        {
            System.out.print(root.val+" ");
            return;
        }

        leafNode(root.left);
        leafNode(root.right);
    }

    static void rightNode(Node root)
    {
        if (root==null) return;
        if (root.left==null && root.right==null) return;
        if (root.right!=null) rightNode(root.right);
        else rightNode(root.left);
        System.out.print(root.val+" ");
    }

    static void boundryPrinting(Node root)
    {
        leftNode(root);
        leafNode(root);
        rightNode(root.right);
    }

    static void rightSideview(Node root,int level,int[] arr)
    {
        if (root==null) return;
        arr[level] = root.val;
        rightSideview(root.left,level+1,arr);
        rightSideview(root.right,level+1,arr);
    }

    static void leftSideview(Node root,int level,int[] arr)
    {
        if (root==null) return;
        arr[level-1] = root.val;
        leftSideview(root.right,level+1,arr);
        leftSideview(root.left,level+1,arr);
    }

    static int heightOfTree(Node root)
    {
        if (root==null || (root.left==null && root.right==null)) return 0;

        return (1+Math.max(heightOfTree(root.left),heightOfTree(root.right)));
    }

    public static void main(String[] args) {

        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        Node h=new Node(8);
        Node i=new Node(9);
        Node j=new Node(10);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.left=h;
        d.right=i;
        e.left=j;

        String[] arr2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

//        int n=heightOfTree(a);
//        int[] arr = new int[n+1];
//        rightSideview(a,1,arr);

//        preorder(createBinaryTree(arr2));


    }
}
