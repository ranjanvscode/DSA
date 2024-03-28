package Stack;

import java.util.Stack;

public class StackBasic {

    static void display(Stack<Integer> stc)
    {
        if (stc.size()==0)
        {
            return;
        }
        int x=stc.pop();
        display(stc);
        System.out.print(x+" ");
        stc.push(x);
    }

    static void pushAtBottom(Stack<Integer> stc, int y)
    {
        if (stc.size()==0)
        {
            stc.push(y);
            return;
        }
        int x=stc.pop();
        pushAtBottom(stc,y);
        stc.push(x);
    }

    static void popAtBottom(Stack<Integer> stc)
    {
        if (stc.size()==1)
        {
            stc.pop();
            return;
        }
        int x=stc.pop();
        popAtBottom(stc);
        stc.push(x);
    }

    static void reverse(Stack<Integer> stc)
    {
        if (stc.size()==0)
        {
            return;
        }
        int x=stc.pop();
        reverse(stc);
        pushAtBottom(stc,x);
    }


    public static void main(String[] args) {
        Stack<Integer> stc = new Stack<>();

        stc.push(1);
        stc.push(2);
        stc.push(3);
        stc.push(4);
        stc.push(5);
        stc.push(6);
        stc.push(7);
        stc.push(8);
        stc.push(9);
        stc.push(10);

        System.out.println(stc);
        display(stc);
    }
}
