package Stack;

import java.util.Stack;

public class StackLeetcodeProblem {

    static boolean balancedBracket(String str) //Check whether a given bracket sequence is balanced or not.
    {
        Stack<Character> stc = new Stack<>();
        int num=0;
        int push = 0;
        int pop = 0;

        while (num<str.length())
        {
            if (str.charAt(num)=='(')
            {
                stc.push('(');
            }
            else {
                if (stc.size()==0) return false;
                stc.pop();
            }
            num++;
        }

        return stc.size() == 0;
    }  // End

    static void removeMinBracketToMakeItBalance(String str) // Find the minimum number of brackets that we need
    {                                                       // to remove to make the given bracket sequence balanced.
        Stack<Character> stc = new Stack<>(); // We have to improve something
        int num=0;
        int push = 0;
        int pop = 0;

        while (num<str.length())
        {
            if (str.charAt(num)=='(')
            {
                push++;
            }
            else {
                pop++;
            }
            num++;
        }

        if (push==pop)
        {
            System.out.println("OK");
        }else if (push>pop)
        {
            System.out.println((push-pop));
        }else {
            System.out.println((pop-push));
        }
    } // End

    static int[] nextGreaterNumber(int [] arr) // Next greater number using stack bcz of T.C - O(n)
    {
        int n= arr.length;
        int[] res = new int[n];

        Stack<Integer> stc = new Stack<>();

        for (int i=n-1;i>=0;i--)
        {
            res[i] = -1;
            while (stc.size()>0 && arr[i]>stc.peek())
            {
                stc.pop();
            }
            if(stc.size()==0) res[i] = -1;
            else res[i] = stc.peek();

            stc.push(arr[i]);
        }
        return res;
    }  // End

    static int[] prevGreaterNumber(int [] arr) // Previous greater number using stack bcz of T.C - O(n)
    {
        int n= arr.length;
        int[] res = new int[n];

        Stack<Integer> stc = new Stack<>();

        for (int i=0;i<n;i++)
        {
            res[i] = -1;
            while (stc.size()>0 && arr[i]>stc.peek())
            {
                stc.pop();
            }
            if(stc.size()==0) res[i] = -1;
            else res[i] = stc.peek();

            stc.push(arr[i]);
        }
        return res;
    }  // End

    static int[] highestFromPrevDays(int [] arr) // Kisi bhi index par diya gya number pichhle kitne dino se highest raha hai.
    {                                           // It's called stock price snap, ye stock price pichhle kitne dino se high hai.
        int n= arr.length;
        int[] res = new int[n];

        Stack<Integer> stc = new Stack<>();
        stc.push(0);
        res[0] = 1;

        for (int i=1;i<n;i++)
        {
            while (stc.size()>0 && arr[i]>arr[stc.peek()])
            {
                stc.pop();
            }
            if (stc.size()==0) res[i] = i+1;
            else
                res[i] = i - stc.peek();

            stc.push(i);
        }
        return res;
    }  // End

    static void prevSmallerNum(int[] arr)
    {
        Stack<Integer> stc = new Stack<>();
        int l= arr.length;
        int[] res = new int[l];

        for (int i=0;i<l;i++)
        {
            res[i] = -1;

            while (stc.size()>0 && arr[i]<stc.peek())
            {
                stc.pop();
            }

            if (stc.size()==0)
            {
                res[i] = -1;
            }else {
                res[i] = stc.peek();
            }

            stc.push(arr[i]);
        }

        for(int x:res)
        {
            System.out.print(x+" ");
        }
    } // End

    static void nextSmallerNum(int[] arr)
    {
        Stack<Integer> stc = new Stack<>();
        int l= arr.length;
        int[] res = new int[l];


        for (int i=l-1;i>=0;i--)
        {
            res[i] = -1;

            while (stc.size()>0 && arr[i]<stc.peek())
            {
                stc.pop();
            }

            if (stc.size()==0)
            {
                res[i] = -1;
            }else {
                res[i] = stc.peek();
            }

            stc.push(arr[i]);
        }

        for(int x:res)
        {
            System.out.print(x+" ");
        }
    } // End

    static void maxAreaOfHistogram(int[] arr)
    {
        int len = arr.length;
        int[] prevRes = new int[len];
        int[] nextRes = new int[len];

        Stack<Integer> stc = new Stack<>();

        for (int i=0;i<len;i++)// Previous smaller number.
        {
            while (stc.size()>0 && arr[i]<=arr[stc.peek()])
            {
                stc.pop();
            }

            if (stc.size()==0)
            {
                prevRes[i] = -1;
            }
            else prevRes[i]= stc.peek();

            stc.push(i);
        }

//        for (int x:prevRes)
//        {
//            System.out.print(x+" ");
//        }

        System.out.println();
        while (stc.size()>0) stc.pop(); // Empty Stack

        for (int i=len-1;i>=0;i--)// Next smaller number.
        {
            while (stc.size()>0 && arr[i]<=arr[stc.peek()])
            {
                stc.pop();
            }

            if (stc.size()==0)
            {
                nextRes[i] = len;
            }
            else nextRes[i] = stc.peek();

            stc.push(i);
        }
//
//        for (int x:nextRes)
//        {
//            System.out.print(x+" ");
//        }
//        System.out.println();

        int max = -1;

        for (int i=0;i<len;i++)
        {
            int area = arr[i]*(nextRes[i]-prevRes[i]-1);
            System.out.print(area+" ");
            max = Math.max(max,area);
        }

        System.out.println("Max area: "+ max);
        System.out.println();

    } // End

    static void maxAreaOfHistogram2(int[] arr) // Time limit exceed.
    {
        int n=arr.length;
        int max = -1;
        for(int i=0;i<n;i++)
        {   int l=i;
            int count=1;
            while (l!=n-1 && arr[i]<=arr[l+1])
            {
                count++;
                l++;
            }
            l=i;
            while (l!=0 && arr[i]<=arr[l-1])
            {
                count++;
                l--;
            }

            int area = arr[i]*count;
            System.out.print(area+" ");
            max = Math.max(max,area);
        }

        System.out.println(max);
    } // End

    static class MinStack // Smallest number in whole stack, T.C (1) but S.C O(n)
    {
    static Stack<Integer> stc = new Stack<>();
    static Stack<Integer> gtc = new Stack<>();

    static void push(int x)
    {
            if (stc.size()==0)
            {
                stc.push(x);
                gtc.push(x);
            } else if (x >= gtc.peek())
            {
                stc.push(x);
                gtc.push(gtc.peek());
            }else {
                stc.push(x);
                gtc.push(x);
            }
    }

    static void pop()
    {
        stc.pop();
        gtc.pop();
    }

    static int top()
    {
        return stc.peek();
    }

    static int min()
    {
        return gtc.peek();
    }
} // End

    static class MinStack2 // Smallest number in whole stack, T.C (1) and S.C O(1)
    {
    static Stack<Integer> stc = new Stack<>();
    static int min ;

    static void push(int x)
    {
        if (stc.size()==0)
        {
            stc.push(x);
            min=x;
        } else if (x >= min)
        {
            stc.push(x);
        }else {

            stc.push(x-2*min);
            min=x;
        }
    }

    static void pop()
    {
        if (stc.peek()>=min)
        {
            stc.pop();
        }else {
            min=(min+stc.peek())/2;
            stc.pop();
        }

    }

    static int top()
    {
        return stc.peek();
    }

    static int min()
    {
        return min;
    }
} // End

    static void infixEvaluation(String str)
    {
    int len = str.length();
    int res=0;
    Stack<Integer> val = new Stack<>();
    Stack<Character> opr = new Stack<>();

    for (int i=0;i<len;i++)
    {
        char ch = str.charAt(i);

        if (48<=(int)ch && 58>(int)ch)
        {
             val.push((int)ch-48);
        }
        else if (opr.size()==0 || ch=='(' || opr.peek()=='(')  // Yadi stack khali ho ya opening bracket mil jaye ya
            opr.push(ch); // Operator stack me pahle se hi opening bracket ho to char ko opr me daal do
        else if (ch==')') // If ch find closing bracket then we will start calculating within bracket
        {
            while (opr.peek()!='(') // It will calculate till opening bracket
            {
                int v2 = val.pop();
                int v1 = val.pop();

                if (opr.peek()=='+') res = v1+v2;
                if (opr.peek()=='-') res = v1-v2;
                if (opr.peek()=='*') res = v1*v2;
                if (opr.peek()=='/') res = v1/v2;

                val.push(res);
                opr.pop(); // Deleting +,-,*,/ after their work is done
            }
            opr.pop(); // At the end delete '('.
        }
        else {
            if (ch=='+' || ch=='-')
            {
                    int v2 = val.pop();
                    int v1 = val.pop();

                    if (opr.peek()=='+') res = v1+v2;
                    if (opr.peek()=='-') res = v1-v2;
                    if (opr.peek()=='*') res = v1*v2;
                    if (opr.peek()=='/') res = v1/v2;

                    val.push(res);
                    opr.pop();
                    opr.push(ch);
            }
            else // Calculate if he will find * or /.
            {
                    if (opr.peek()=='*' || opr.peek()=='/')
                    {
                        int v2 = val.pop();
                        int v1 = val.pop();

                        if (opr.peek()=='*') res = v1*v2;
                        if (opr.peek()=='/') res = v1/v2;

                        val.push(res);
                        opr.pop();
                        opr.push(ch);
                    } else if (opr.peek()=='-') { // yadi ch me * ya / ho aur Operator ke peek me -(minus) ho to value ko negative karne ka kaam.
                        int v2 = val.pop();
                        val.push(-1*v2);
                        opr.pop();
                        opr.push('+');
                        opr.push(ch);
                    } else opr.push(ch); // yadi +(plus) aa jaye to no tension bhai.
            }
        }
    }

    while (val.size()>1) // Sabhi character aur num ko daalne ke baad stack me kuchh num bach jaate hai to use calculate karne ka kaam.
    {
        int v2 = val.pop();
        int v1 = val.pop();

        if (opr.peek()=='+') res = v1+v2;
        if (opr.peek()=='-') res = v1-v2;
        if (opr.peek()=='*') res = v1*v2;
        if (opr.peek()=='/') res = v1/v2;

        val.push(res);
        opr.pop();
    }

    System.out.println(val.peek());
} // End
    static void infixToPrefix(String str)
    {
        int len = str.length();

        Stack<String> val = new Stack<>();
        Stack<Character> opr = new Stack<>();

        for (int i=0;i<len;i++)
        {
            char ch = str.charAt(i);

            if (48<=(int)ch && 58>(int)ch)
            {
                val.push(""+ch);
            }
            else if (opr.size()==0 || ch=='(' || opr.peek()=='(')
                opr.push(ch);
            else if (ch==')')
            {
                while (opr.peek()!='(')
                {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char op = opr.pop();

                    val.push(op+v1+v2);
                    System.out.println(val.peek());
                }
                opr.pop(); // At the end delete '('.
            }
            else {
                if (ch=='+' || ch=='-')
                {
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char op = opr.pop();

                    val.push(op+v1+v2);
                    System.out.println(val.peek());

                    if (opr.size()>0 && (opr.peek()=='-' || opr.peek()=='+'))
                    {
                         v2 = val.pop();
                         v1 = val.pop();
                         op = opr.pop();

                        val.push(op+v1+v2);
                    }
                    opr.push(ch);
                }
                else // Calculate if he will find * or /.
                {
                    if (opr.peek()=='*' || opr.peek()=='/')
                    {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char op = opr.pop();

                        val.push(op+v1+v2);
                        System.out.println(val.peek());
                        opr.push(ch);
                    }
                    else opr.push(ch);
                }
            }// Else if
        } // For Loop

        while (val.size()>1) // Sabhi character aur num ko daalne ke baad stack me kuchh num bach jaate hai to use calculate karne ka kaam.
        {
            String v2 = val.pop();
            String v1 = val.pop();
            char op = opr.pop();

            val.push(op+v1+v2);

            System.out.println(val.peek());
        }

        System.out.println(val.peek());
    } // End

    static int answer(int v1, int v2, char ch) // function to calculate answer
    {
        int res=0;

        if (ch=='+') res = v1+v2;
        if (ch=='-') res = v1-v2;
        if (ch=='*') res = v1*v2;
        if (ch=='/') res = v1/v2;

        return res;
    }

    static int precedence(char ch) // Check precedence of operator
    {
        if (ch=='+') {
            return 1;
        }else if (ch=='-') {
            return 1;
        }else if (ch=='*') {
            return 2;
        } else return 2;
    }

    static void infixEval(String str)   // Better infix evaluation
    {
        int n=str.length();
        Stack<Integer> stc = new Stack<>(); // Store number
        Stack<Character> opr = new Stack<>(); // Store operator
        Stack<Character> str2 = new Stack<>(); // Store all string

        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            int num = (int)ch;

            if (ch=='(') {

                opr.push(ch);
                str2.push(ch);

            }else if (num>=48 && num<58) {

                if (str2.size()>0 && str2.peek()>=48 && str2.peek()<58) { // If number is more than 1 digit then convert
                    int x=stc.pop()*10+(num-48);
                    stc.push(x);
                }
                else
                    stc.push(num-48);


                str2.push(ch);

            }else if (ch==')') {

                while (opr.peek()!='(') {

                    char ch2 = opr.pop();
                    int v2=stc.pop();
                    int v1=stc.pop();

                    stc.push(answer(v1, v2, ch2));
                }

                opr.pop();

            }else if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {

                while (opr.size()>0 && opr.peek()!='(' &&  precedence(ch)<=precedence(opr.peek())) {

                    char ch2 = opr.pop();
                    int v2=stc.pop();
                    int v1=stc.pop();

                    stc.push(answer(v1, v2, ch2));
                }

                opr.push(ch);
                str2.push(ch);
            }
        }

        while (stc.size()>1) {
            char ch2 = opr.pop();
            int v2=stc.pop();
            int v1=stc.pop();

            stc.push(answer(v1, v2, ch2));
        }

        System.out.println(stc.peek());
    }


    static void infixToPrefix2(String str) // Better Approach
    {
        int n=str.length();
        Stack<String> stc = new Stack<>(); // Store number
        Stack<Character> opr = new Stack<>(); // Store operator

        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            int num = (int)ch;

            if (ch=='(') {

                opr.push(ch);

            }else if (num>=48 && num<58) {

                stc.push(Character.toString(ch));

            }else if (ch==')') {

                while (opr.peek()!='(') {

                    char ch2 = opr.pop();
                    String v2=stc.pop();
                    String v1=stc.pop();

                    stc.push(ch2+v1+v2);
                }

                opr.pop();

            }else if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {

                while (opr.size()>0 && opr.peek()!='(' &&  precedence(ch)<=precedence(opr.peek())) {

                    char ch2 = opr.pop();
                    String v2=stc.pop();
                    String v1=stc.pop();

                    stc.push(ch2+v1+v2);
                }

                opr.push(ch);
            }
        }

        while (stc.size()>1) {

            char ch2 = opr.pop();
            String v2=stc.pop();
            String v1=stc.pop();

            stc.push(ch2+v1+v2);
        }

        System.out.println(stc.peek());
    }

    static void postfixEval(String str) // Postfix Evaluation
    {
        int n=str.length();
        Stack<Integer> nums = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char ch1 = str.charAt(i);
            int ch = (int)ch1;


            if (ch>=48 && ch<58) {
                nums.push(ch-48);
            }else
            {
                int v2=nums.pop();
                int v1=nums.pop();

                nums.push(answer(v1, v2, ch1));
            }
        }

        System.out.println(nums.peek());
    }

    static void prefixEval(String str) // Prefix Evaluation
    {
        int n=str.length();
        Stack<Integer> nums = new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            char ch = str.charAt(i);
            // int ch = (int)ch1;


            if (Character.isDigit(ch)) {
                nums.push(ch-48);
            }else
            {
                int v1=nums.pop();
                int v2=nums.pop();

                nums.push(answer(v1, v2, ch));
            }
        }

        System.out.println(nums.peek());
    }

    static void prefixToPostfix(String str)
    {
        int n=str.length();
        Stack<String> nums = new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            char ch = str.charAt(i);
            // int ch = (int)ch1;


            if (Character.isDigit(ch)) {
                nums.push(Character.toString(ch));
            }else
            {
                String v1=nums.pop();
                String v2=nums.pop();

                nums.push(v1+v2+ch);
            }
        }

        System.out.println(nums.peek());
    }

    static void postfixToPrefix(String str)
    {
        int n=str.length();
        Stack<String> nums = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char ch = str.charAt(i);
            // int ch = (int)ch1;


            if (Character.isDigit(ch)) {
                nums.push(Character.toString(ch));
            }else
            {
                String v2=nums.pop();
                String v1=nums.pop();

                nums.push(ch+v1+v2);
            }
        }

        System.out.println(nums.peek());
    }

    static void postfixToInfix(String str)
    {
        int n=str.length();
        Stack<String> nums = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char ch = str.charAt(i);
            // int ch = (int)ch1;


            if (Character.isDigit(ch)) {
                nums.push(Character.toString(ch));
            }else
            {
                String v2=nums.pop();
                String v1=nums.pop();

                nums.push("("+v1+ch+v2+")");
            }
        }

        System.out.println(nums.peek());
    }

    static void slidingWindow(int[] arr, int k) {
    int l = arr.length;
    int j=0;
    int max = Integer.MIN_VALUE;
    int[] ans = new int[l - k + 1];
    int[] nge = new int[l];

    Stack<Integer> stc = new Stack<>();

    for (int i=l-1;i>=0;i--) // next greater number
    {

        while (stc.size()>0 && arr[i]>arr[stc.peek()])
        {
            stc.pop();
        }
        if (stc.size()==0) nge[i] = l;
        else nge[i] = stc.peek();

        stc.push(i);
    }

    for (int i = 0; i <= l - k; i++)// sliding window
    {
        if (j>=i+k) j=i;

        while (j<i+k)
        {
            max = arr[j];
            j=nge[j];
        }
        ans[i]=max;
    }

    for (int x:arr)
    {
        System.out.print(x+" ");
    }

    System.out.println();
    for (int x:ans)
    {
        System.out.print(x+" ");
    }
}

    static int celebrityProblem(int[][] arr, int k)
    {
    int n= arr.length;
    Stack<Integer> stc = new Stack<>();
    for (int i=0;i<k;i++)
    {
        stc.push(i);
    }

    while (stc.size()>1)
    {
        int v1 = stc.pop();
        int v2 = stc.pop();

        if (arr[v1][v2]==0) stc.push(v1);
        else if (arr[v2][v1]==0) stc.push(v2);
    }

    int celeb = stc.pop();
    for (int i=0;i<n;i++)
    {
        if (arr[celeb][i]==1) return -1;
    }

    for (int i=0;i<n;i++)
    {
        if (i==celeb) continue;
        if (arr[i][celeb] == 0) return -1;
    }

    return celeb;
}

public static void main(String[] args) {

        int [] arr = {5,2,4,6,10,5,8,1,3,4,5};

        int[][] arr2 = {{0,1,0},
                        {0,0,0},
                        {0,1,0}};

        String str = "5/9+5-2+5-5/2*6/5+2-4";

        String str2 = "((3+((6*(5+4))/3))-7)";

        infixEval(str2);
    }
}
