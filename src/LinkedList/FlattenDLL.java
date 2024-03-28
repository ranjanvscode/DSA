package LinkedList;

public class FlattenDLL {

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode child;

        ListNode(int val) {
            this.val = val;
        }

    }

    static class DLLSTR {
        ListNode head = null;
        ListNode tail = null;

        void insertAtEnd(int val) {
            ListNode temp = new ListNode(val);
            if (head == null) {
                head = temp;
                tail = head;
            } else {

                temp.prev = tail;
                tail.next = temp;
                tail = tail.next;
            }

        }

        void insertAtHead(int val) {
            ListNode temp = new ListNode(val);

            if (head == null) {
                head = temp;
                tail = head;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
        }

        void insertAt(int idx, int val) {
            ListNode temp = new ListNode(val);
            ListNode curr = head;
            int num = 1;

            while (num < idx - 1) {
                curr = curr.next;
                num++;
            }

            temp.next = curr.next;
            temp.prev = curr;
            curr.next.prev = temp;
            curr.next = temp;

        }
    }

    static void PrintWithChild(ListNode head)
    {
        ListNode temp=head;

        while (temp!=null)
        {
            System.out.println(temp.val);

            if (temp.child!=null)
                PrintWithChild(temp.child);

            temp = temp.next;

            if (temp==null) return;
        }
    }

    static void PrintSimple(ListNode head)
    {
        ListNode temp=head;

        while (temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static void PrintRev(ListNode head)
    {
        ListNode temp=head;

        while (temp!=null)
        {
            System.out.println(temp.val);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {

        DLLSTR dl = new DLLSTR();
        DLLSTR dl2 = new DLLSTR();
        DLLSTR dl3 = new DLLSTR();

        dl.insertAtEnd(1);
        dl.insertAtEnd(2);
        dl.insertAtEnd(3);
        dl.insertAtEnd(4);
        dl.insertAtEnd(5);
        dl.insertAtEnd(6);
        dl.insertAtEnd(7);
        dl.insertAtEnd(8);

        dl2.insertAtEnd(11);
        dl2.insertAtEnd(12);
        dl2.insertAtEnd(13);
        dl2.insertAtEnd(14);
        dl2.insertAtEnd(15);
        dl2.insertAtEnd(16);
        dl2.insertAtEnd(17);
        dl2.insertAtEnd(18);

        dl.head.next.next.next.child = dl2.head;
        dl2.head.prev = dl.head.next.next.next;

        dl3.insertAtEnd(22);
        dl3.insertAtEnd(23);
        dl3.insertAtEnd(24);
        dl3.insertAtEnd(25);
        dl3.insertAtEnd(26);
        dl3.insertAtEnd(27);
        dl3.insertAtEnd(28);
        dl3.insertAtEnd(29);

        dl2.head.next.next.child = dl3.head;
        dl3.head.prev = dl2.head.next.next;
    }
}
