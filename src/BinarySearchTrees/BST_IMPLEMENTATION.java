package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST_IMPLEMENTATION {

    //Node
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
    static void inorder(Node root)
    {
        if(root==null) return;

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static void postorder(Node root)
    {
        if(root==null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }

    static int size(Node root)
    {
        if (root==null) return 0;

        return (1+size(root.left)+size(root.right));
    }

    static int sumOfNodes(Node root)
    {
        if (root==null) return 0;

        return (root.val+sumOfNodes(root.left)+sumOfNodes(root.right));
    }

    static int maxNode(Node root)
    {
        if (root==null) return Integer.MIN_VALUE;

        return Math.max(root.val,Math.max(maxNode(root.left),maxNode(root.right)));
    }

    static int heightOfTree(Node root)
    {
        if (root==null || (root.left==null && root.right==null)) return 0;

        return (1+Math.max(heightOfTree(root.left),heightOfTree(root.right)));
    }

    //Level order Traversal
    static void levelPrint(Node root,int n)
    {
        if(root==null) return;
        if (n==1) {
            System.out.println(root.val+" ");
            return;
        }
        levelPrint(root.left,n-1);
        levelPrint(root.right,n-1);
    }

    //Breadth First Search(BFS) Traversal
    static void bfs(Node root)//All level order traversal
    {
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);

        while (!q.isEmpty())
        {
            Node temp = q.peek();

            if (temp.left!=null)q.add(temp.left);

            if (temp.right!=null)q.add(temp.right);

            System.out.print(temp.val+" ");

            q.remove();
        }
    }

    //Depth First Search(DFS) Traversal
    public static void preorderTraversalUsingStack(Node root)
    {
        Stack<Node> stc = new Stack<>();

        stc.add(root);

        while (!stc.isEmpty())
        {
            Node node = stc.pop();

            System.out.print(node.val+" ");

            if (node.right != null)
                stc.push(node.right);

            if (node.left != null)
                stc.push(node.left);

        }
    }

    public static void inorderTraversalUsingStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
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

        System.out.println(size(a));
        System.out.println(sumOfNodes(a));
        System.out.println(maxNode(a));
        System.out.println(heightOfTree(a));

        // Level by level printing.
//        int level = heightOfTree(a)+1;// T.C = O(n logn) thoda kharab hai
//        for(int x=1;x<=level;x++)
//            levelPrint(a,4);


//        bfs(a);
//        preorder(a);
//        System.out.println();
//        inorder(a);
//        System.out.println();
//        postorder(a);
//        System.out.println();
//        inorderTraversalUsingStack(a);
//        System.out.println();
//        preorderTraversalUsingStack(a);

    }
}
