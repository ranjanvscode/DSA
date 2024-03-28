package Backtracking;

import java.util.ArrayList;
import java.util.Objects;

public class nQueenProblem {

    public static int nQueen(String[][] arr,int row,ArrayList<Integer> count)
    {
        int len = arr.length;

        if (row==len) // Base Case
        {
            for (String[] str:arr)//If possible then print
            {
                for (String s:str)
                {
                    System.out.print(s+" ");
                }
                System.out.println();
            }
            System.out.println();

            count.add(1);//Adding total possible combination
            return count.size();//Return total possible combination
        }

        for (int j=0;j<len;j++)
        {
            if (isSafe(arr,row,j)){ // Checking that, is safe to place Queen here?.
                arr[row][j]="Q";//If safe then place
                nQueen(arr,row+1,count);//Recursion
                arr[row][j]="X";//Backtracking - Means if not safe then make that place again empty at the time of returning.
            }
        }

        return count.size();
    }

    private static boolean isSafe(String[][] arr, int row, int col) {

        int len = arr.length;

        for (int j=0;j<len;j++) if (Objects.equals(arr[row][j], "Q")) return false; //Row wise

        for (String[] strings : arr) if (Objects.equals(strings[col], "Q")) return false;//Column wise

        int i=row,j=col;
        while (i>=0 && j<len)//NE
        {
            if (Objects.equals(arr[i][j], "Q")) return false;
            i--;j++;
        }

        i=row;j=col;
        while (i<len && j>=0)//SW
        {
            if (Objects.equals(arr[i][j], "Q")) return false;
            i++;j--;
        }

        i=row;j=col;
        while (i>=0 && j>=0)//NW
        {
            if (Objects.equals(arr[i][j], "Q")) return false;
            i--;j--;
        }

        i=row;j=col;
        while (i<len && j<len)//SE
        {
            if (Objects.equals(arr[i][j], "Q")) return false;
            i++;j++;
        }

        return true;
    }


    public static void main(String[] args) {

        int n=5;
        ArrayList<Integer> count = new ArrayList<>();
        String[][] arr = new String[n][n];

        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]="X";
            }
        }

        int t=nQueen(arr,0,count);

        System.out.println(t);
    }
}
