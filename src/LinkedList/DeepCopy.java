package LinkedList;

public class DeepCopy {

    public static class ListNode // Node
    {
        int val;
        ListNode next;
        ListNode random;
        ListNode(int val){
            this.val = val;
        }

    }

    public static class LLDS2 // Class for creating LL
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

    static void Print(ListNode head)
    {
        ListNode temp = head;

        while (temp!=null)
        {
            if (temp.random!=null)
                System.out.println(temp.val+" : "+ temp.random.val);
            else
                System.out.println(temp.val+" : "+ temp.random);

            temp = temp.next;
        }
    }

    static void Print2(ListNode head)
    {
        ListNode temp = head;
        while (temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    static void DeepCopyList(ListNode head) // Creating deep copy of linked list with random pointer.
    {
        ListNode temp=head;
        ListNode copy = new ListNode(-1);
        ListNode tempCopy=copy;

        while (temp!=null) // Creating deep copy of Linked List
        {
            ListNode temp2 = new ListNode(temp.val);
            tempCopy.next = temp2;
            tempCopy = temp2;
            temp = temp.next;
        }

        temp = head;
        ListNode tempNext;
        tempCopy = copy.next;
        ListNode tempCopyNext;

        while (temp!=null) // Converting both list in single list
        {
          tempNext = temp.next;
          temp.next = tempCopy;

          tempCopyNext = tempCopy.next;
          tempCopy.next = tempNext;

          temp = tempNext;
          tempCopy = tempCopyNext;
        }

        temp = head;
        tempCopy = copy.next;

        while (temp!=null) // Inserting random value in second list
        {
            if (temp.random!=null)
                tempCopy.random = temp.random.next;
            temp = temp.next.next;

            if (tempCopy.next!=null)
             tempCopy = tempCopy.next.next;
        }

        temp = head;
        tempCopy = copy.next;

        while (temp!=null) // Separating both list
        {
            temp.next = tempCopy.next;
            temp = tempCopy.next;

            if (temp!=null)
            {
                tempCopy.next = temp.next;
                tempCopy = temp.next;
            }
        }

        Print(copy.next);

    }

    public static void main(String[] args) {

        LLDS2 Obj = new LLDS2();

        Obj.InsertAtEnd(1);
        Obj.InsertAtEnd(2);
        Obj.InsertAtEnd(3);
        Obj.InsertAtEnd(4);
        Obj.InsertAtEnd(5);
        Obj.InsertAtEnd(6);
        Obj.InsertAtEnd(7);
        Obj.InsertAtEnd(8);
        Obj.InsertAtEnd(9);
        Obj.InsertAtEnd(10);

//        Obj.head.random = Obj.head.next.next.next.next.next.next;
        Obj.head.next.random = Obj.head.next.next.next.next;
        Obj.head.next.next.random = Obj.head.next.next.next.next.next.next.next;
//        Obj.head.next.next.next.random = Obj.head.next.next.next.next.next.next;
//        Obj.head.next.next.next.next.random = Obj.head.next.next.next.next.next.next.next.next.next;
        Obj.head.next.next.next.next.next.random = Obj.head;
//        Obj.head.next.next.next.next.next.next.random = Obj.head.next.next.next.next.next.next.next.next;
        Obj.head.next.next.next.next.next.next.next.random = Obj.head.next;
        Obj.head.next.next.next.next.next.next.next.next.random = Obj.head.next;
        Obj.head.next.next.next.next.next.next.next.next.next.random = Obj.head.next;

        Print(Obj.head);
        System.out.println();
        DeepCopyList(Obj.head);

    }
}
