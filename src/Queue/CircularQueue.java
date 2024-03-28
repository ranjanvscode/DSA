package Queue;

public class CircularQueue {  // Array implementation of circular queue.

    int r=-1;
    int f=-1;
    int size=0;
    int[] arr = new int[10];
    int l= arr.length;

    void push(int val)
    {
        if (size==l)
        {
            System.out.println("Queue is full");
            return;
        }
        if (f==-1)
        {
            f=r=0;
            arr[0] = val;
        }
        else if(r<l-1)
        {
            arr[++r]=val;
        }else {
            r=0;
            arr[r]=val;
        }
        size++;
    }

    int pop()
    {
        if (size==0)
        {
            System.out.println("Queue is empty.");
            return -1;
        }

        int x=arr[f];

        if (f<l-1)
        {
            f++;

        }else {
            f=0;
        }
        size--;
        return x;
    }

    int peek()
    {
        return arr[f];
    }

    void display()
    {
        if (size==0)
        {
            System.out.println("Queue is empty");
            return;
        }

        if (f<r)
        {
            for (int i=f;i<=r;i++)
                System.out.print(arr[i]+" ");
        }
        else
        {
            for (int i=f;i<l;i++)
                System.out.print(arr[i]+" ");

            for (int i=0;i<=r;i++)
                System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue();

        cq.push(1);
        cq.push(2);
        cq.push(3);
        cq.push(4);
        cq.push(5);
        cq.push(6);
    }
}
