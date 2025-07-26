package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedList2  {

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
        }

    }

    public static void merge(ListNode h1, ListNode h2) // Merge two sorted LL in sorted way
    {
        ListNode t1=h1;
        ListNode t2=h2;

        ListNode h = new ListNode(100);
        ListNode t = h;

        while (t1!=null&&t2!=null)
        {
            if (t1.val<t2.val)
            {
                t.next=t1;
                t=t1;
                t1 = t1.next;
            }
            else
            {
                t.next = t2;
                t=t2;
                t2 = t2.next;
            }

        }
        if (t1 == null)
        {
            t.next = t2;
        }
        else
        {
            t.next = t1;
        }

        Print(h.next);

    }

    static void splitOddEven(ListNode head)//Using extra space, O(n)
    {
        ListNode curr = head;
        ListNode oddHead = new ListNode(-1), oddTail = oddHead ;

        ListNode evenHead = new ListNode(-1), evenTail = evenHead ;


        while (curr!=null)
        {
            if (curr.val%2==0)
            {
                evenTail.next = curr;
                evenTail = curr;
            }
            else
            {
                oddTail.next = curr;
                oddTail = curr;
            }
            curr = curr.next;

        }
        oddTail.next = null;

        evenTail.next = oddHead.next;

        Print(evenHead.next);
    }

    static void splitOddEven2(ListNode head) // Without using extra space, O(1)
    {
        ListNode curr = head;
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddHead = null;
        ListNode oddTail = null;

        while (curr!=null)
        {
            if (curr.val%2==0)
            {
                if (evenHead==null)
                {
                    evenHead = curr;
                    evenTail = evenHead;
                }
                else
                {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }
            else
            {
                if (oddHead==null)
                {
                    oddHead = curr;
                    oddTail = oddHead;
                }
                else
                {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }

        if (oddHead!=null)
        {
            oddTail.next = null;
        }

        if (evenHead == null)
        {
            evenHead = oddHead;
        }
        else
        {
            evenTail.next = oddHead;
        }

        Print(evenHead);
    }

    static void removeDuplicate(ListNode head) // Remove Duplicate ele in sorted LL.
    {
        ListNode temp = head;

        while (temp.next!=null)
        {
            if (temp.val == temp.next.val )
            {
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }

        Print(head);

    }

    static ListNode reverseLL(ListNode head) // Reverse LL with recursion, O(n)
    {
        if (head.next == null) return head;
        ListNode newHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return  newHead;
    }

    static ListNode reverseLL2(ListNode head) // Reverse LL without recursion, O(1)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode Next;

        while (curr!=null)
        {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

    static ListNode middleEle(ListNode head)// Find left middle ele of LL
    {
        ListNode slow=head;
        ListNode fast=head;

        while (fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    static boolean palindrome(ListNode head)
    {
        ListNode mid = middleEle(head);
        ListNode p1=head;
        ListNode p2=mid.next;
        p2 = reverseLL2(p2);

        while (p2!=null)
        {
            if (p1.val!= p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static void maximumTwinSum(ListNode head)
    {
        ListNode mid = middleEle(head);
        ListNode p1=head;
        ListNode p2=mid.next;
        p2 = reverseLL2(p2);
        int num=0,temp=0,num1=0,num2=0;
        while (p2!=null)
        {
            temp = p1.val+ p2.val;
            if (num<temp)
            {
                num = temp;
                num1= p1.val;
                num2= p2.val;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("Maximum twin sum = "+num);
        System.out.println();
        System.out.println("Twin1 : "+num1+" , Twin2 : "+num2);
    }

    static void splitNodeInOddEvenPlace(ListNode head) // Place oddth place node left side and eventh place node in right place.
    {
        ListNode curr = head.next.next;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;
        ListNode oddTail = head;
        int num=1;

        while (curr!=null)
        {
            oddTail.next = curr;
            curr = curr.next;
            oddTail = oddTail.next;

            evenTail.next = curr;
            if (curr == null) break;
            curr = curr.next;
            evenTail = evenTail.next;
        }

        evenTail.next = null;
        oddTail.next = evenHead;

        Print(head);

    }

    static ListNode deepCopy(ListNode head)
    {
        ListNode newHead = new ListNode(-1);
        ListNode newTemp = newHead;

        while (head!=null)
        {
            newTemp.next = new ListNode(head.val);
            newTemp = newTemp.next;
            head = head.next;
        }
        return newHead.next;
    }

    static boolean hasCycle(ListNode head) {

        if(head==null || head.next==null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){

            slow = head.next;
            fast = head.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void Print(ListNode head)
    {
        ListNode temp = head;

        while (temp != null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
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
    }
}
