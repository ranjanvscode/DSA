package Stack;

public class StackImplementation { // Stack Implementation of Array

    int size=0;
    int top = -1;
    int[] arr = new int[10];

    void push(int val) throws Exception
    {
        if (size==arr.length)
        {
            throw new Exception("Stack is full");
        }
        arr[++top]=val;
        size++;
    }

    int pop() throws Exception
    {
        if (size==0)
        {
            throw new Exception("Stack is empty");
        }
        int x=arr[top];
        top--;
        size--;
        return x;
    }

    int peek() throws Exception
    {
        if (size==0)
        {
            throw new Exception("Stack is empty");
        }

        return arr[top];
    }

    int size() throws Exception
    {
        if (size==0)
        {
            throw new Exception("Stack is empty");
        }
        return size;
    }

    void display()  throws Exception
    {
        if (size==0)
        {
            throw new Exception("Stack is empty");
        }
        for (int i=0;i<=top;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) throws Exception {

        StackImplementation stc = new StackImplementation();

        stc.push(1);
        stc.push(2);
        stc.push(3);
        stc.push(4);
        stc.push(5);
        stc.push(6);
        stc.push(7);
        stc.push(8);


    }
}
