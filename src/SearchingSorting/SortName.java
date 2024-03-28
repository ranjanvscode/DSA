package SearchingSorting;

import java.lang.reflect.Array;

public class SortName { // Sort Name of anything in lexicographical order

    static void sorting(String[] str)
    {
        int n= str.length;

        for (int i=0;i<n;i++)
        {
            int min_idx = i;
            boolean flag = false;

            for (int j=i+1;j<n;j++)
            {
                if (str[min_idx].compareTo(str[j])>0)
                {
                    min_idx=j;
                    flag = true;
                }
            }

            // Swaping
            if (!flag) break;

            String temp = str[i];
            str[i] = str[min_idx];
            str[min_idx] = temp;
        }

        for(String x:str)
        {
            System.out.print(x+" ");
        }
    }
    public static void main(String[] args) {
        String[] str = {"Ranjan", "Manoj", "Deepak", "Pawan", "Kaushal","Sharwan"};

        sorting(str);


    }
}
