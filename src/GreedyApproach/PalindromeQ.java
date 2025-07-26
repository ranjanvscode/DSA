//Given a number first check that this can be a palindrome number by arranging them and then print max palindrome number;

package GreedyApproach;

import java.util.ArrayList;
import java.util.List;

public class PalindromeQ {

    private static boolean validate(List<Integer> freq)
    {
        boolean isOdd = false;

        for (int i=0;i<10;i++)
        {
            if (freq.get(i)%2 != 0 )
            {
                if (isOdd)
                    return false;

                isOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String num = "545";
//        String num = "363265215";

        List<Integer> freq = new ArrayList<>();

        int len = num.length();

        for (int i=0;i<10;i++)
            freq.add(0);

        for (int i=0;i<len;i++)
        {
            int idx = num.charAt(i)-'0';
            freq.set(idx, freq.get(idx)+1);
        }

        if (!validate(freq))
            System.out.println("Palindrome is not possible");
        else
        {
            StringBuilder firstHalf = new StringBuilder();

            for (int i=9;i>=0;i--)
            {
                while (freq.get(i)>1)
                {
                    firstHalf.append(i);
                    freq.set(i, freq.get(i)-2);
                }
            }

            StringBuilder secondHalf = new StringBuilder(firstHalf);
            secondHalf.reverse();


            for (int i=9;i>=0;i--)
            {
                if (freq.get(i)==1)
                {
                    firstHalf.append(i);
                    freq.set(i, freq.get(i)-1);
                }
            }

            String result = firstHalf.append(secondHalf).toString();
            System.out.println(result);
        }
    }
}
