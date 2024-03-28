package Queue;

import java.util.*;
public class QueuePractice {

    void reverse(Queue<Integer> q)
    {
        Stack<Integer> st = new Stack<>();

        while (q.size()>0)
        {
            st.push(q.remove());
        }

        while (st.size()>0)
        {
            q.add(st.pop());
        }
    }

    void reverseFirstK_Ele(Queue<Integer> q,int k)
    {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n=q.size();
        int l=q.size();

        while (q.size()>0)
        {
            if (q.size()>l-k)
                st.push(q.remove());
            else
                q2.add(q.remove());
        }

        while (n>0)
        {
            if (n>l-k)
                q.add(st.pop());
            else
                q.add(q2.remove());

            n--;
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        QueuePractice qp = new QueuePractice();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        System.out.println(q);
//        qp.reverse(q);
        qp.reverseFirstK_Ele(q,6);
        System.out.println(q);

    }
}
