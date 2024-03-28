import java.util.List;
import java.util.ListResourceBundle;

public class LL_Practice {

    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
            ListNode next = null;
        }
    }

    static class LLStr
    {
        ListNode head=null;
        ListNode tail=null;

         void Insert(int num)
        {
            ListNode temp = new ListNode(num);
            if (head == null)
            {
                head = temp;
                tail = head;
            }
            else
            {
                tail.next=temp;
                tail = temp;
            }

        }
    }

    static void Print(ListNode head)
    {
        ListNode temp = head;
        while (temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static int count(ListNode head)
    {
        ListNode temp = head;
        int num=1;

        if (head == null) return 0;
        while (temp.next!=null)
        {
            num++;
            temp = temp.next;
        }
        return num;
    }

    static ListNode deleteNode(ListNode head, int target)
    {
        ListNode temp=head.next;
        ListNode prev = head;

        if (head.val==target)
        {
            head = head.next;
            return head;
        }

        while (temp!=null)
        {
            if (temp.val==target)
            {
                prev.next = temp.next;
                return head;

            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Given target num is not available in List");
        return head;
    }

    static ListNode deleteNode2(ListNode head, int idx)
    {
        ListNode temp=head.next;
        ListNode prev = head;
        int num=1;

        if (head==null || idx>count(head))
        {
            System.out.println("Something is wrong");
            return null;
        }

        if(idx==1)
        {
            head = head.next;
            return head;
        }

        while (num<idx)
        {
            if (num==idx-1)
            {
                prev.next = temp.next;
                return head;

            }
            num++;
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Given target num is not available in List");
        return head;
    }



    static void middleEle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        if (head == null)
        {
            System.out.println("List has no element");
            return;
        }
        while (fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.val);

    }

    static void revers(ListNode head)
    {
        ListNode prev = null;
        ListNode Next = null;
        ListNode curr = head;

        while (curr!=null)
        {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        Print(prev);
    }

    static boolean hasCycle(ListNode head) // This function can find that List has cycle or not.
    {
        ListNode slow = head;
        ListNode fast = head;

        if(head == null) return false;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }

    static ListNode firstNodeOfCycle(ListNode head)
    {


        ListNode slow = head;
        ListNode fast = head;

        if(head == null) return null;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;

                while(slow!=fast)
                {
                    slow=slow.next;
                    fast = fast.next;
                }

                return slow;
            }

        }

        return null;
    }

    static void revers2(ListNode head, int left, int right)
    {


        ListNode beforeLeft = null;
        ListNode temp = head;

        ListNode Left = null;
        ListNode Right = null;

        ListNode prev = null;
        ListNode Next = null;

        int num=1;

        while(temp!=null)
        {
            if(left==num) Left = temp;

            if (left==1)
            {
                beforeLeft = head;
            }else if (left-1==num) beforeLeft=temp;

            if(right==num) Right = temp;
            temp = temp.next;
            num++;
        }

        assert Right != null;
        ListNode afterRight = Right.next;
        temp = Left;

        while(temp!=afterRight)
        {
            Next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = Next;
        }

//        assert beforeLeft != null;
//        beforeLeft.next= prev;
//
//        Left.next = afterRight;

        Print(prev);
    }

    static void rotate(ListNode head,int num) // rotate left to right
    {
        ListNode tail = head;
        ListNode nextHead=null;
        ListNode curr = head;

        if(head==null || num<1) return;
        int len=1;
        int k=1;

        while (tail.next!=null)
        {
            tail = tail.next;
            len++;
        }

        num = num%len;

        while (k<=num)
        {
            nextHead = head.next;
            head.next = null;
            tail.next = head;
            tail = tail.next;
            head = nextHead;
            k++;
        }
        Print(head);
    }

    static void rotate2(ListNode head,int k) // rotate right to left
    {


        ListNode tail = head;
        ListNode nextHead=head;

        if(head==null || k<1) return;

        int num=1;
        int len=1;

        while (tail.next!=null)
        {
            tail = tail.next;
            len++;
        }

        int rotation = k%len;
        int newTra = len-rotation;
        tail.next = head;

        while (num<newTra)
        {
            nextHead = nextHead.next;
            num++;
        }

          head = nextHead.next;
          nextHead.next = null;

        Print(head);

    }

    static void findNthNodeFromEnd(ListNode head,int NthNode) // Finding Nth node from the end of list.
    {
        ListNode temp = head;
        int num = count(temp) -NthNode+1;
        int x=1;

        while (x<=num)
        {
            if (x==num)
             System.out.println(temp.val);
            temp = temp.next;
            x++;
        }
    }

    static void findNthNodeFromEnd2(ListNode head,int NthNode) // Finding Nth node from the end of list 2.
    {
        ListNode fast = head;
        ListNode slow = head;
        int num = 1;

        while (fast!=null)
        {
            if (num>NthNode)
            {
                slow = slow.next;
            }
            num++;
            fast = fast.next;
        }

        assert slow != null : "Nth Node is not available in list";
        System.out.println(slow.val);
    }

    static void removingNthNodeFromEnd2(ListNode head,int NthNode) // Removing Nth node from the end of list.
    {
        ListNode fast = head;
        ListNode slow = head;
        int num = 1;

        while (fast!=null)
        {
            if (num>NthNode+1)
            {
                slow = slow.next;
            }
            num++;
            fast = fast.next;
        }

        assert slow != null;
        slow.next = slow.next.next;
        Print(head);

    }

    public static void main(String[] args) {

        LLStr ll = new LLStr();

        ll.Insert(2);
        ll.Insert(4);
        ll.Insert(6);
        ll.Insert(8);
        ll.Insert(10);
        ll.Insert(12);
        ll.Insert(14);
        ll.Insert(16);
        ll.Insert(18);
        ll.Insert(20);


//        Print(ll.head);
//        System.out.println(count(ll.head));
//        middleEle(ll.head);
//        revers(ll.head);
//        revers2(ll.head,1,1);
//        rotate(ll.head,2);

//        Print(deleteNode(ll.head, 50));
//        System.out.println();
//        Print(deleteNode2(ll.head, 20));

//        findNthNodeFromEnd2(ll.head, 20);
        removingNthNodeFromEnd2(ll.head,3);





    }

}
