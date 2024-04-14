package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class BT_IntermediatQues {

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

    //Creating Binary tree using preorder and inorder value
    //TC = O(N log n) best case, //TC = O(n^2) worst case
    static Node createBinaryTree(int[] preOrder,int preLowIdx,int preHiIdx,int[] inOrder,int inLowIdx,int inHiIdx)
    {
        if (preLowIdx>preHiIdx) return null;

        Node root = new Node(preOrder[preLowIdx]);
        int i=inLowIdx;
        while (preOrder[preLowIdx]!=inOrder[i]) i++;
        int leftNodeSize = i-inLowIdx;
        root.left = createBinaryTree(preOrder,preLowIdx+1,preLowIdx+leftNodeSize,inOrder,inLowIdx,i-1);
        root.right = createBinaryTree(preOrder,preLowIdx+leftNodeSize+1,preHiIdx,inOrder,i+1,inHiIdx);
        return root;
    }

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

    //Path Sum - 1
    static boolean hasSumPath1(Node root,int target,int sum,String str)
    {
        if (root==null) return false;

        sum = sum+root.val;

        if (root.left==null && root.right==null){
            if (sum==target)
            {
                System.out.println(str+root.val);
                return true;
            }
        }
        return hasSumPath1(root.left,target,sum,str+root.val+"->") || hasSumPath1(root.right,target,sum,str+root.val+"->");
    }

    public static void treeSumPath2(Node root, List<List<Integer>> ans, List<Integer> arr, int target, int sum)
    {

        if (root==null) return;

        sum = sum+root.val;
        arr.add(root.val);

        if (root.left==null && root.right==null){
            if (sum==target)
            {
                List<Integer> temp = new ArrayList<>();

                for(int i=0;i<arr.size();i++)
                {
                    temp.add(arr.get(i));
                }
                ans.add(temp);
            }
            arr.remove(arr.size()-1);//leaf node par pahuchne ke baad Right left dono remove karenge
            return;
        }

        treeSumPath2(root.left,ans,arr,target,sum);

        treeSumPath2(root.right,ans,arr,target,sum);
        arr.remove(arr.size()-1);//Kewal right side nikalte samay remove karega

    }

    static int pathSum3Helper(Node root,int target,int sum)
    {
        if (root==null) return 0;
        sum+= root.val;
        int count=0;
        if (sum==target) count++;

        return count+pathSum3Helper(root.left,target,sum)+pathSum3Helper(root.right,target,sum);
    }

    static int pathSum3(Node root,int target)
    {
        if (root==null) return 0;

        int count=pathSum3Helper(root,target,0);

        count+=pathSum3(root.left,target)+pathSum3(root.right,target);

        return count;

    }

    static void flattenBinaryTreeRecursively(Node root)
    {
        if (root==null) return;
//        if (root.left==null && root.right==null) return;

        flattenBinaryTreeRecursively(root.left);
        flattenBinaryTreeRecursively(root.right);

        Node leftTree = root.left;
        Node rightTree = root.right;

        if (leftTree!=null && rightTree!=null)
        {
            while (leftTree.right!=null)
            {
                leftTree = leftTree.right;
            }

            leftTree.right=rightTree;
            rightTree = leftTree;
            leftTree = null;
        }

        if (leftTree != null && rightTree==null)
        {
            rightTree = leftTree;
            leftTree = null;
        }
    }


    public static void main(String[] args) {

        int[] preOrder = {1, 2, 4 ,8 ,9 ,5 ,10, 11, 3, 6, 12, 13, 7 ,14, 15 };
        int[] inOrder = {8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15 };

        int n= preOrder.length;
        Node root = createBinaryTree(preOrder,0,n-1,inOrder,0,n-1);
//        levelOrderTraversal(root);
//        boolean f=hasSumPath1(root,25,0,"");
//        System.out.println(f);

        //List of tree branch whose sum is equal ot target.
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> arr = new ArrayList<>();
//        treeSumPath2(root,ans,arr,19,0);
//        System.out.println(ans);

    }
}
