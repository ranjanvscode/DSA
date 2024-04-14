package Backtracking;
public class SudokuSolver {
    static int check=0;
    static boolean isSafe(int[][] grid,int r,int c,int num)
    {
        
        int i,j;
        
        for(i=0;i<9;i++)
            if(grid[i][c]==num) return false;
            
        for(j=0;j<9;j++)
            if(grid[r][j]==num) return false;
        
        int sr = r/3*3; // Starting row
        int sc = c/3*3; // Starting column
        
        for(i=sr;i<sr+3;i++)
            for(j=sc;j<sc+3;j++)
                if(grid[i][j]==num) return false;
                
        
        return true;
    }
    
    static boolean sudokuHelper(int[][] grid,int r,int c)
    {
        boolean flag = true;
        
        if(r==9)
        {
            check=1;
            return flag;
        }else{
            
            if(grid[r][c]!=0){
                
                if(c!=8) flag =  sudokuHelper(grid,r,c+1);
                else flag =  sudokuHelper(grid,r+1,0);
            }else{
                
                for(int i=1;i<=9;i++)
                {
                    if(isSafe(grid,r,c,i))
                    {
                        grid[r][c]=i;
                        
                        if(c!=8) {
                            flag =  sudokuHelper(grid,r,c+1);
                        }
                        else
                        {
                            flag =  sudokuHelper(grid,r+1,0);
                        }

                        if (check==1) return flag;

                        grid[r][c]=0;//Backtracking
                        
                    }
                }
            }
        }
        
        return flag;
    }
    
    
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return sudokuHelper(grid,0,0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {   
        for(int[] subArr:grid)
        {
            for(int num:subArr)
            {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //int[][] grid = new int[9][9];// This Sudoku question fillen by leetcode, geekforgeeks or youself.

        int[][] grid =
                {{0 ,0 ,8 ,4, 2, 0, 5, 6 ,3},
                {3 ,0 ,0 ,9 ,5 ,0 ,0 ,7 ,0},
                {0 ,0 ,7 ,1 ,8 ,3 ,0 ,9 ,0},
                {4 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0},
                {0 ,0 ,5 ,6 ,0 ,0 ,0 ,3 ,1},
                {0 ,9 ,0 ,0 ,3 ,8 ,2 ,4 ,0},
                {8 ,2 ,0 ,0 ,0 ,0 ,0 ,0 ,9},
                {5 ,6 ,0 ,0 ,0 ,0 ,7 ,0 ,0},
                {7 ,0 ,0 ,8 ,4 ,1 ,6 ,2 ,5}};
    
        System.out.println(SolveSudoku(grid));//True or false

        printGrid(grid);
    }
}
