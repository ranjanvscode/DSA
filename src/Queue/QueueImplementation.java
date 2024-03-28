package Queue;

public class QueueImplementation {  // Array Implementation of Queue

    private int val;
    private int f=-1;
    private int r=-1;
    private int size=0;
    private final int[] arr = new int[10];

    public void add(int val)
    {
        if (size == arr.length) {
            System.out.println("Queue is full.");
            return;
        }

        if (f==-1)
        {
            f=r=0;
            arr[f] = val;
        }
        else {
            arr[++r] = val;
        }
        size++;
    }

    public void remove()
    {
        if (size==0)
        {
            System.out.println("Queue is empty");
            return;
        }
        f++;
        size--;
    }

    public void display()
    {
        if (size==0)
        {
            System.out.println("Queue is empty");
            return;
        }

        for (int i=f;i<=r;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void peek()
    {
        if (size==0)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(arr[f]);
    }

    public static void main(String[] args) {

        QueueImplementation q = new QueueImplementation();

//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(4);
//        q.add(8);
    }

    public void ranjan() {
        System.out.println("Ranjan");
    }
}
