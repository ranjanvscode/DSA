import java.util.ArrayList;

public class Permutation {

    public static String swap(String str,int i,int j) // Long code of permutation
    {
        char[] charArr = str.toCharArray();

        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }

    public static void permute(String str, int l,ArrayList<String> list) // Long code of permutation
    {
        int r=str.length()-1;

        if (l == r)
        {
            list.add(str);
        }
        else
        {
            for (int i=l;i<=r;i++)
            {
                str = swap(str,l,i);
                permute(str,l+1,list);
                str = swap(str,l,i);//Backtracking
            }
        }
    }

    public static void permutation(String str, String permu)// Short code of permutation
    {
        if (str.isEmpty())
        {
            return;
        }

        for (int i=0;i<str.length();i++)
        {
            char currChar = str.charAt(i);

            String newStr = str.substring(0,i)+str.substring(i+1);

            permutation(newStr,permu+currChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        int n=str.length();
        ArrayList<String> list = new ArrayList<>();

        permute(str,0,list);

        System.out.println(list);

    }
}