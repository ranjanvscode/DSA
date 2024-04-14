package BinaryTrees;

import java.util.*;

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
    static void levelOrderTraversal(Node root)
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

    public static void inorderTraversalUsingStack(Node root)
    {
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

    //post Order Traversal using one stack
    public static void postOrderTraversalUsingStack(Node root)
    {

         Stack<Node> stc = new Stack<>();

         Node current = root;

         while (current!=null || !stc.isEmpty())
         {
             if (current!=null)
             {
                 stc.add(current);
                 current = current.left;
             }else
             {
                 Node temp = stc.peek().right;

                 if (temp==null)
                 {
                     temp = stc.pop();//popped num
                     System.out.print(temp.val+" ");

                     while (!stc.isEmpty() && temp==stc.peek().right)// it will check that popped num is in right side or left, if left then it will pop again
                     {
                         temp=stc.pop();
                         System.out.print(temp.val+" ");
                     }
                 }else
                 {
                     current = temp;
                 }
             }
         }
    }

    //post Order Traversal using one stack
    public static void postOrderTraversalUsingStack2(Node root)
    {
        Stack<Node> stc1 = new Stack<>();
        Stack<Node> stc2 = new Stack<>();

        stc1.add(root);

        while (!stc1.isEmpty())
        {
            Node temp = stc1.pop();
            stc2.add(temp);
            if (temp.left!=null) stc1.add(temp.left);
            if (temp.right!=null) stc1.add(temp.right);
        }

        while (!stc2.isEmpty())
        {
            System.out.print(stc2.pop().val+" ");
        }
    }

    public static int diameterOfTree(Node root)
    {

         if (root==null || (root.left==null && root.right==null))
             return 0;

         int leftHeight = diameterOfTree(root.left);
         int rightHeight = diameterOfTree(root.right);
         int mid = heightOfTree(root.left)+heightOfTree(root.right);
         if (root.left!=null) mid++;
         if (root.right!=null) mid++;
         int max = Math.max(mid,Math.max(leftHeight,rightHeight));

         return max;
    }

    public static boolean balanceTree(Node p,Node q)
    {
        if(p==null && q==null) return true;
        if (p==null || q==null) return false;
        if(p.val!=q.val) return false;

        return balanceTree(p.left,q.left) && balanceTree(p.right,q.right);
    }

    public static void binaryTreePath(Node root, List<String> ans,String str)
    {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            str+=root.val;
            ans.add(str);
            return;
        }

        binaryTreePath(root.left,ans,str+root.val+"->");
        binaryTreePath(root.right,ans,str+root.val+"->");
    }

    public static boolean contains(Node root, Node target)
    {
        if (root==null) return false;
        if (target==root) return true;
        return contains(root.left, target) || contains(root.right,target);
    }

    public static Node lowestCommonAncestor(Node root,Node p,Node q)
    {
        if (p==root || q==root) return root;
        if (p==q) return p;
        boolean leftNode = contains(root.left,p);
        boolean rightNode = contains(root.right,q);

        if ((leftNode && rightNode) || (!leftNode && !rightNode)) return root;
        if (leftNode && !rightNode)  return lowestCommonAncestor(root.left,p,q);
        if (!leftNode && rightNode)  return lowestCommonAncestor(root.right,p,q);

        return root;
    }
    public static void main(String[] args) {

        List<String> ans = new ArrayList<>();

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

//        System.out.println(size(a));
//        System.out.println(sumOfNodes(a));
//        System.out.println(maxNode(a));
//        System.out.println(heightOfTree(a));

        // Level by level printing.
//        int level = heightOfTree(a)+1;// T.C = O(n logn) thoda kharab hai
//        for(int x=1;x<=level;x++)
//            levelPrint(a,4);

//        levelOrderTraversal(a);

//        preorder(a);
//        System.out.println();
//        inorder(a);
//        System.out.println();
//        postorder(a);
//        System.out.println();

//        inorderTraversalUsingStack(a);
//        System.out.println();
//        preorderTraversalUsingStack(a);


//        inorderTraversalUsingStack(a);

//        System.out.println(diameterOfTree(a));

//        binaryTreePath(a,ans,"");
//        System.out.println(ans);

//        postOrderTraversalUsingStack2(a);

//        Node node = lowestCommonAncestor(a, h, j);
//        System.out.println(node.val);

    }
}
