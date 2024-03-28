package Backtracking;

public class knightLike_nQueen {

    public static boolean isSafe(String[][] grid,int row,int col)
    {
        int n = grid.length;

        int i,j;

        //UR
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j]=="K") return false;

        //UL
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j]=="K") return false;

        //DR
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j]=="K") return false;

        //DL
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j]=="K") return false;

        //RU
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j]=="K") return false;

        //RD
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j]=="K") return false;

        //LU
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j]=="K") return false;

        //LD
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j]=="K") return false;

        return true;
    }

    public static void knight(String[][] grid,int row,int col) {

        int n=grid.length;

        if (row==n) {
            for(String[] str:grid)
            {
                for(String s:str)
                {
                    System.out.print(s+" ");
                }
                System.out.println();
            }
            System.out.println();

            return;
        }


            if (isSafe(grid,row,col)) {

                grid[row][col]="K";

                if(col!=n-1) knight(grid, row,col+1);
                else knight(grid, row+1,0);

                grid[row][col]="X";
            }
            // For only one first answer pls add else condition here
                if(col!=n-1) knight(grid, row,col+1);
                else knight(grid, row+1,0);


    }

    public static void main(String[] args) {

        String[][] grid = new String[3][3];


        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                grid[i][j]="X";
            }
        }

        knight(grid, 0,0);
    }
}
