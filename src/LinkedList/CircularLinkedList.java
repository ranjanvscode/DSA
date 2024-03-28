package LinkedList;

import java.util.Stack;

public class CircularLinkedList {

    public static class ListNode // Node
    {
        int val;

        ListNode next;
        ListNode(int val){
            this.val = val;
        }

    }

    public static class LLDS // Class for creating LL
    {
        ListNode head = null;
        ListNode tail = null;

        void InsertAtEnd(int num)
        {
            ListNode temp = new ListNode(num);
            if (head == null)
            {
                head = temp;
            }else
            {
                tail.next = temp;
            }

            tail = temp;
            tail.next=head;
        }

    }
    static void Print(ListNode head)
    {
        ListNode temp = head;

        System.out.println(temp.val);
        temp = temp.next;

        while (temp!=head)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static ListNode deleteHeadInCLL(ListNode head)
    {
        ListNode temp = head;

        while (temp.next!=head)
        {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return temp = temp.next;
    }

    public static void main(String[] args) {

        LLDS LL1 = new LLDS();
        LLDS l1 = new LLDS();
        LLDS l2 = new LLDS();

        l1.InsertAtEnd(1);
        l1.InsertAtEnd(3);
        l1.InsertAtEnd(5);
        l1.InsertAtEnd(7);
        l1.InsertAtEnd(7);
        l1.InsertAtEnd(5);
        l1.InsertAtEnd(3);
        l1.InsertAtEnd(2);

        l2.InsertAtEnd(20);
        l2.InsertAtEnd(41);
        l2.InsertAtEnd(60);
        l2.InsertAtEnd(85);
        l2.InsertAtEnd(10);
        l2.InsertAtEnd(12);
        l2.InsertAtEnd(14);
        l2.InsertAtEnd(16);

        LL1.InsertAtEnd(1);
        LL1.InsertAtEnd(2);
        LL1.InsertAtEnd(3);
        LL1.InsertAtEnd(4);
        LL1.InsertAtEnd(5);
        LL1.InsertAtEnd(6);
        LL1.InsertAtEnd(7);
        LL1.InsertAtEnd(8);
        LL1.InsertAtEnd(9);
        LL1.InsertAtEnd(10);
        LL1.InsertAtEnd(11);
        LL1.InsertAtEnd(12);

        Print(deleteHeadInCLL(l2.head));

    }
}
