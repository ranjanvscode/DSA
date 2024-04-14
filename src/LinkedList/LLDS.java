package LinkedList;

public class LLDS {

    public static class Node
    {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class LLDataStructure{
        Node head = null;
        Node tail = null;
         void insertLastEle(int data)
         {
             Node temp = new Node(data);

             if (head==null)
             {
                 head = temp;
             }else {
                 tail.next = temp;
             }

             tail = temp;
         }

        void insertFirstEle(int data)
        {
            Node temp = new Node(data);

            if (head==null)
            {
                head = temp;
            }else {
                temp.next = head;
                head=temp;
            }


        }

        void insertAt(int idx, int val)
        {
            Node nTemp = new Node(val);
            Node temp=head;
            if (idx==size(head))
            {
                insertLastEle(val);
                return;
            }
            else if (idx==0)
            {
                insertFirstEle(val);
                return;
            }
            else if (idx<0 || idx>size(head))
            {
                System.out.println("Enter valid index number.");
                return;
            }
            for (int i=1;i<=idx-1;i++)
            {
                temp = temp.next;
            }
            nTemp.next = temp.next;
            temp.next = nTemp;
        }

        int size(Node Temp)
        {
            Node temp =Temp;
            int count=1;
            while (temp.next!=null)
            {
                count++;
                temp = temp.next;
            }
//            System.out.println("\nSize of Node: "+count);
            return count;
        }

         void display(Node tHead)
         {
//             Node pData = head;
             Node pData = tHead;
             while(pData!=null)
             {
                 System.out.print(pData.data+" ");
                 pData = pData.next;
             }
         }

         Node getNthNodeFromLast(int n)
         {
             int totalNode = size(head);
             int gn = totalNode-n+1;
             Node temp = head;

             for (int i=1;i<=gn-1;i++)
             {
                 temp = temp.next;
             }

             return temp;
         }

         void deleteNthNodeFromLast(int idx)
         {
             Node slow = head,fast = head;
             for (int i=1;i<=idx;i++)
             {
                 fast = fast.next;
             }
             while (fast.next!=null)
             {
                 slow = slow.next;
                 fast = fast.next;
             }
             assert slow.next != null;
             slow.next = slow.next.next;

         }

         Node intersectionNode(Node headA,Node headB)
         {
             Node temp1 = headA;
             Node temp2 = headB;

             int llSize1=size(temp1);
             int llSize2=size(temp2);

             int diff=0;

             if(llSize1>llSize2)
             {
                 diff = llSize1 - llSize2;
                 for(int i=1;i<=diff;i++)
                 {
                     temp1 = temp1.next;
                 }
             }
             else
             {
                 diff = llSize2 - llSize1;
                 for(int i=1;i<=diff;i++)
                 {
                     temp2 = temp2.next;
                 }
             }

             while(temp1.data!=temp2.data)
             {
                 temp1 = temp1.next;
                 temp2 = temp2.next;
             }

             return temp1;
         }

         void middleEle(Node temp)
         {
             Node fast=temp;
             Node slow=temp;

             while (fast!=null && fast.next!=null && fast.next.next!=null) // for left middle in even ele in LL.
//             while (fast.next !=null)
             {
                 slow = slow.next;
                 fast = fast.next.next;
             }

             System.out.println();
             assert slow != null;
             System.out.println(slow.data);
         }

         void  deleteMiddleEle(Node head)
         {
             Node fast=head;
             Node slow=head;
                 Node temp = null;

             while (fast.next!=null && fast.next.next!=null)
             {
                 temp = slow;
                 slow = slow.next;
                 fast = fast.next.next;
             }
             temp.next = temp.next.next;
         }


    }
    public static void main(String[] args) {

        LLDataStructure t = new LLDataStructure();

        t.insertLastEle(56);
        t.insertLastEle(81);
        t.insertLastEle(42);
        t.insertLastEle(20);
        t.insertLastEle(12);
        t.insertLastEle(10);

        LLDataStructure t2 = new LLDataStructure();

        t2.insertLastEle(25);
        t2.insertLastEle(36);
        t2.insertLastEle(56);
        t2.insertLastEle(81);
        t2.insertLastEle(44);
        t2.insertLastEle(42);
        t2.insertLastEle(20);
        t2.insertLastEle(12);
        t2.insertLastEle(10);
        t2.insertLastEle(23);
        t2.insertLastEle(96);
        t2.insertLastEle(16);

        t2.display(t2.head);
        System.out.println();
        t2.middleEle(t2.head);

    }
}
