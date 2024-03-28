import java.util.ArrayList;

public class Recursion {

    static ArrayList<String> subsetOfString(String str)
    {
        ArrayList<String> ar = new ArrayList<>();

        if (str.length()==0)
        {
            ar.add("");
            return ar;
        }

        char ch=str.charAt(0);

        ArrayList<String> ar2 = subsetOfString(str.substring(1));

        for (String ss:ar2)
        {
            ar.add(ch+ss);
            ar.add(ss);
        }

        return ar;
    }

    static void subsetOfString2(String str, String currStr)
    {
        if (str.length()==0)
        {
            System.out.println(currStr);
            return;
        }

        char ch=str.charAt(0);

        String remainStr = str.substring(1);

        subsetOfString2(remainStr,currStr+ch);
        subsetOfString2(remainStr,currStr);
    }

    static void sumOfSubset(int[] arr, int idx,int x)
    {
        if (arr.length==idx) {
            System.out.print(x+" ");
            return;
        }

        sumOfSubset(arr,idx+1,x+arr[idx]);
        sumOfSubset(arr,idx+1,x);
    }


    //List of sub array of given num array.
    static ArrayList<Integer> subArray1(int[] arr,ArrayList<Integer> ans,int l,int sum)
    {
       if (l==arr.length) {

        ans.add(sum);
        return ans;
       }

       int x=arr[l];

       subArray1(arr,ans, l+1,sum);
       
       subArray1(arr,ans, l+1,sum+x);

       return ans;
    }

    static int frogJump(int[] arr,int idx,int n) // Frog jump
    {
        if (idx==n-1)
        {
            return 0;
        }

        int op1 = Math.abs(arr[idx]-arr[idx+1])+frogJump(arr,idx+1,n);

        if (idx==n-2)
        {
            return op1;
        }

        int op2 = Math.abs(arr[idx]-arr[idx+2])+frogJump(arr,idx+2,n);

        return Math.min(op1,op2);
    }

    static void Keypad(String str,int n,String res)// Keypad combination
    {

        String[] strArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        if (str.length()==0)
        {
            System.out.println(res);
            return;
        }

        int dig = str.charAt(0)-'0';

        String key=strArr[dig];

        for (int i=0;i<key.length();i++)
        {
            Keypad(str.substring(1),n,res+key.charAt(i));
        }
    }

    static int PossiblePath(int i,int j,int n,int m)
    {
        if (i==n && j==m)
        {
            return 0;
        }
        if (i==n-1 || j==m-1)
        {
            return 1;
        }

        return PossiblePath(i,j+1,n,m)+PossiblePath(i+1,j,n,m);
    }
    static int power(int p,int q)
    {
        if (q==0)
        {
            return 1;
        }

        if (q==1)
        {
            return p;
        }

        if (q%2==0)
        {
            return power(p,q/2)*power(p,q/2);
        }
        else  return power(p,q/2)*power(p,q/2)*p;
    }

    // Check question in apna college channel in recursion video
    static int numOfPair(int n)
    {
        if (n<=1){
            return 1;
        }
        int ways1 = numOfPair(n-1);
        int ways2 = (n-1)*numOfPair(n-2);
        return ways1 + ways2;
    }

    static int towerOfHanoi(int n,String source,String helper,String destination)
    {
        if (n==1) {
            System.out.println(n+" "+source+" "+destination);
            return 1;
        }

        int op1 = towerOfHanoi(n-1, source, destination, helper);
        System.out.println(n+" "+source+" "+destination);
        int op2 = towerOfHanoi(n-1,helper, source, destination);

        return op1+op2+1;
    }

    static boolean checkSortedArray(int[] arr,int idx) // chekcing that given array is sorted or not
    {
        if (idx==arr.length-1) {
            return true;
        }

        if (arr[idx]>=arr[idx+1]) {
            return false;
        }


        return checkSortedArray(arr, idx+1);
    }


    //remove duplicate from string
    static String removeDuplicate(String str, int idx,String res, int idx2)
    {

        if (idx==str.length()) {
            return res;
        }

        if (str.charAt(idx)!=res.charAt(idx2)) {
            res+=str.charAt(idx);
            idx2++;
        }

        return removeDuplicate(str,idx+1,res,idx2);
    }

    //remove duplicate from string using boolean array.
    static boolean[] map = new boolean[26];
    static String removeDuplicate2(String str, int idx,String res)
    {
        if (idx==str.length()) {

            return res;
        }

        char ch=str.charAt(idx);

        if (map[ch-'a']) {

            return removeDuplicate2(str, idx+1, res);
        }
        else
        {
            res+=ch;
            map[ch-'a']=true;
            return removeDuplicate2(str, idx+1, res);
        }
    }


    // Number of total ways to reach at top
    static int numOfStairPath(int n,int res)
    {

        if (n==0) {
            System.out.println(res);
            return 1;
        }

        if (n==1) {

            res=res*10+1;

            System.out.println(res);

            return 1;
        }

        int way1=numOfStairPath(n-1,res*10+1);

        int way2=numOfStairPath(n-2, res*10+2);

        return way1+way2;

    }

    static int fibonacciNumber(int n)
    {
        if (n==0 ) {
            return 0;
        }
        if (n==1 || n==2) {
            return 1;
        }

        return fibonacciNumber(n-1)+fibonacciNumber(n-2);
    }

    // max num of Valid bracket 
    static void bracket(int n, int open, int close, String str) {
        if (open==n && close==n){
        System.out.println(str);
        return;
        }
        if (open<n)
        bracket(n,  open+1, close, str+"(");
        if (close<open)
        bracket (n, open,  close+1,str+")");
        return;
        }
    //HCF
    public static int hcf(int x,int y)
    {
        if (x%y==0) {
            return y;
        }

        return hcf(y, x%y);
    }
    //LCM
    public static int lcm(int x,int y)
    {
        int hcf = hcf(x, y);

        return (12*16)/hcf;
    }
    public static void main(String[] args) {

//            System.out.println( fibonacciNumber(10));
        // System.out.println(subsetOfString("ranj"));
//        System.out.println(lcm(12,16));

//        int[] arr = {5,3,8,6,1,8,2,7,6,1,8};
//        System.out.println(frogJump(arr,0,arr.length));

        Keypad("263",2,"");
    }
}