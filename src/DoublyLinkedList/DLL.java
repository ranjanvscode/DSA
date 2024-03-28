package DoublyLinkedList;

import java.util.Stack;

public class DLL {

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

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

    static void Print(ListNode head)// Print from head
    {
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static void Print2(ListNode tail) // Print from tail
    {
        ListNode temp = tail;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.prev;
        }
    }

    static void Print3(ListNode Node) // Print from any node
    {
        ListNode temp = Node;

        while (temp.prev != null) {
            temp = temp.prev;
        }

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    static ListNode deleteAtHead(ListNode head) {
        ListNode temp = head;

        if (temp == null || temp.next == null) {
            System.out.println("No Element in List");
            return null;
        } else {
            temp = temp.next;
            temp.prev = null;
        }
        return temp;
    }

    static ListNode deleteAtTail(ListNode tail) {
        ListNode temp = tail;

        if (temp == null || temp.prev == null) {
            System.out.println("No Element in List");
            return null;
        } else {
            temp = temp.prev;
            temp.next = null;
        }

        while (temp.prev != null) {
            temp = temp.prev;
        }
        return temp;
    }

    static ListNode deleteAtAnyIndex(ListNode head, int idx) {
        ListNode temp = head;

        if (temp == null) {
            System.out.println("No Element in List");
            return null;
        } else if (idx == 1) {
            return deleteAtHead(head);
        } else {
            for (int i = 1; i < idx - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            if (temp.next != null)
                temp.next.next.prev = temp;
        }
        return head;
    }

    static boolean palindrome(ListNode head, ListNode tail) {

        while (head != tail) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    static void twoSum(ListNode head, ListNode tail, int target) //
    {
        ListNode hTemp = head;
        ListNode tTemp = tail;

        while (hTemp != tail && tTemp != head) {
            if (hTemp.val + tTemp.val == target) {
                System.out.println(hTemp.val + "+" + tTemp.val + "=" + target);
                return;
            }
            if (hTemp.val + tTemp.val < target) {
                hTemp = hTemp.next;
            }
            if (hTemp.val + tTemp.val > target) {
                tTemp = tTemp.prev;
            }
        }
        System.out.println("Target sum is not possible");
    }
    static void minMaxCriticalPoint(ListNode head, ListNode tail) {
        int minDist = Integer.MAX_VALUE;
        int count = 0;
        ListNode temp = head;
        ListNode nextCP;

        while (temp != null) // Minimum distance
        {
            if (isCriticalPoint(temp)) {
                nextCP = nextCriticalPoint(temp.next);
                if (nextCP != null) {
                    while (temp != nextCP) {
                        count++;
                        temp = temp.next;
                    }
                    if (minDist > count) minDist = count;
                    count = 0;
                    temp = temp.prev;
                }
            }// 1 if
            temp = temp.next;
        }// while
        System.out.println("Minimum distance between Critical point: "+minDist);

        temp = head;
        ListNode lastCP = lastCriticalPoint(tail);

        while (temp!=null) // Maximum distance
        {
            if (isCriticalPoint(temp))
            {
                while (temp!=lastCP)
                {
                    count++;
                    temp = temp.next;
                }
                System.out.println("Maximum distance between Critical point: "+count);
                return;
            }
            temp = temp.next;
        }// While
    }

    static boolean isCriticalPoint(ListNode curr) {
        if (curr.prev == null || curr.next == null) return false;
        else return curr.prev.val < curr.val && curr.next.val < curr.val;
    }

    static ListNode nextCriticalPoint(ListNode curr) {
        while (curr != null) {
            if (isCriticalPoint(curr))
                return curr;
            else
                curr = curr.next;
        }
        return null;
    }

    static ListNode lastCriticalPoint(ListNode tail)
    {
        ListNode curr = tail;
        while (curr != null) {
            if (isCriticalPoint(curr))
                return curr;
            else
                curr = curr.prev;
        }
        return null;
    }

    public static void main(String[] args) {

        DLLSTR dl = new DLLSTR();

        dl.insertAtEnd(1);
        dl.insertAtEnd(2);//
        dl.insertAtEnd(1);
        dl.insertAtEnd(3);
        dl.insertAtEnd(12);
        dl.insertAtEnd(18);//
        dl.insertAtEnd(15);
        dl.insertAtEnd(10);
        dl.insertAtEnd(12);//
        dl.insertAtEnd(9);
        dl.insertAtEnd(22);
        dl.insertAtEnd(22);
        dl.insertAtEnd(19);
        dl.insertAtEnd(22);//
        dl.insertAtEnd(20);
    }
}
