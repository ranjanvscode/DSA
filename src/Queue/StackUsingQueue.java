package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {

    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
//    Stack<Integer> st = new Stack<>();

    void push(int val)
    {
        if (q.size()==0)
        {
            q.add(val);
        }else {
            while (q.size()>0)
            {
                q2.add(q.remove());
            }

            q.add(val);

            while (q2.size()>0)
            {
                q.add(q2.remove());
            }

        }
    }

    int pop()
    {
        if (q.size()==0)
        {
            System.out.println("Stack is empty.");
            return -1;
        }

        return q.remove();
    }

    int peek()
    {
        if (q.size()==0)
        {
            System.out.println("Stack is empty.");
            return -1;
        }
        return  q.peek();
    }

    int size()
    {
        return q.size();
    }

    void display()
    {
        while (q.size()>0)
        {
            int x=q.remove();
            System.out.print(x+" ");
            q2.add(x);
        }

        while (q2.size()>0)
        {
            q.add(q2.remove());
        }
    }



    public static void main(String[] args) {

        StackUsingQueue sq = new StackUsingQueue();

        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(5);
        sq.push(6);
        sq.push(7);
        sq.push(8);

    }
}
