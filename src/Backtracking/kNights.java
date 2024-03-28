package Backtracking;

public class kNights {

    public static boolean knight(int[][] grid,int row,int col,int num)
    {
        int n = grid.length;

        if(grid[row][col]==n*n-1) return true;

        int i,j;

        //UR
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j]==num) return knight(grid,i,j,num+1);

        //UL
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j]==num) return knight(grid,i,j,num+1);

        //DR
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j]==num) return knight(grid,i,j,num+1);

        //DL
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j]==num) return knight(grid,i,j,num+1);

        //RU
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j]==num) return knight(grid,i,j,num+1);

        //RD
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j]==num) return knight(grid,i,j,num+1);

        //LU
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j]==num) return knight(grid,i,j,num+1);

        //LD
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j]==num) return knight(grid,i,j,num+1);

        return false;
    }
    public static boolean checkValidGrid(int[][] grid) {

        if(grid[0][0]!=0) return false;

        return knight(grid,0,0,1);// (array,row,col,agla step jaha check karna hai)
    }

    public static void main(String[] args) {

        //LeetCode Q-2596.

        //grid array provided by LeetCode otherwise create yourself.
        //Ye function yah check karega ki diye gye array me chess ka ghoda
        //har ek continious chaal chal kar har box me baithta hai ya nahi

        int[][] grid = new int[5][5];//Dummy array

        boolean flag = checkValidGrid(grid);
    }
}
