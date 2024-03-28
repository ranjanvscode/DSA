package Queue;

public class LinkedListImpOfQueue {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class LLDataStructure {

        int size = 0;
        Node head = null;
        Node tail = null;

         void add(int data) {
            Node temp = new Node(data);

            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
            }

            tail = temp;
            size++;
        }

        void display() {
             Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void remove() {
            if (head == null) {
                System.out.println("Queue is empty");
                return;
            }
            head = head.next;
            size--;
        }

        void peek() {
            if (head == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println(head.data);
        }

        void ranjan() {
            if (head == null) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println(size);
        }

    }

    public static void main(String[] args) {

//        QueueImplementation q = new QueueImplementation();

        LLDataStructure qu = new LLDataStructure();

        qu.add(10);
        qu.add(11);
        qu.add(12);
        qu.add(13);
        qu.add(14);
        qu.add(15);
        qu.add(16);

        qu.display();
        qu.remove();
        qu.display();
        qu.remove();
        qu.display();
//        qu.remove();
//        qu.display();
        qu.ranjan();
        qu.peek();
    }
}
