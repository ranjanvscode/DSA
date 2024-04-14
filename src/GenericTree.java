import java.util.*;

import static java.util.Collections.reverse;

public class GenericTree {

    static class Node
    {
        int val;
        List<Node> child;
        Node(int val)
        {
            this.val = val;
            child = new ArrayList<>();
        }
    }

    static void createGenericTree(Node root)
    {
        root.child.add(new Node(2));
        root.child.add(new Node(3));
        root.child.add(new Node(4));

        root.child.get(0).child.add(new Node(5));
        root.child.get(0).child.add(new Node(6));
        root.child.get(0).child.add(new Node(7));

        root.child.get(1).child.add(new Node(8));
        root.child.get(1).child.add(new Node(9));
        root.child.get(1).child.add(new Node(10));

        root.child.get(2).child.add(new Node(11));
        root.child.get(2).child.add(new Node(12));
        root.child.get(2).child.add(new Node(13));
    }

    static void preOrderTraversal(Node root)
    {
        if (root.child.isEmpty())
        {
            System.out.print(root.val+" ");
            return;
        }

        System.out.print(root.val+" ");

        for (Node node:root.child)
        {
            preOrderTraversal(node);
        }
        //For post order print statement should be here
    }

    static void levelOrderTraversal(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            Node temp = q.remove();
            System.out.print(temp.val+" ");

            q.addAll(temp.child);
        }

    }
    static void zigZagTraversal(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag=true;

        while (!q.isEmpty())
        {
            List<Node> list = new LinkedList<>();
            int len = q.size();

            while (len-- > 0)
            {
                Node temp = q.remove();
                q.addAll(temp.child);
                list.add(temp);
            }

            if (flag)
                print(list);
            else
            {
                reverse(list);
                print(list);
            }
            flag = !flag;
        }
    }

    static void print(List<Node> list)
    {
        for (Node node:list)
        {
            System.out.print(node.val+" ");
        }
        System.out.println();
    }

    static int maxOfTree(Node root)
    {
        if (root==null) return 0;

        if (root.child.isEmpty())
        {
            return root.val;
        }

        int max= root.val;

        for (Node node:root.child)
        {
            int num = maxOfTree(node);
            max = Math.max(num, max);
        }

        return max;
    }

    static void mirrorTree(Node root)
    {
        if (root==null) return;

        if (root.child.isEmpty()) return;

        reverse(root.child);

        for (Node node:root.child)
        {
            mirrorTree(node);
        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        for(int i = 0; i < root.child.size()-1; i++){
            inorder(root.child.get(i));
        }
        System.out.print(root.val + " ");
        if(root.child.size() > 1) inorder(root.child.get(root.child.size()-1));
    }
    public static void main(String[] args) {

        Node root = new Node(1);

        createGenericTree(root);

        preOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
////        zigZagTraversal(root);
////        System.out.println("MAX:"+maxOfTree(root));
//        mirrorTree(root);
//        levelOrderTraversal(root);

        inorder(root);

    }
}
