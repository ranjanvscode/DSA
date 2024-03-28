package Backtracking;

public class RatInMaze {

    public static int totalPathInMaze(int[][] arr,int i,int j,int r,int c,String str)//(2D arr with value,0,0,3,3,"")
    {
        if (i<0 || j<0) return 0;
        if (i>r || j>c) return 0;

        if (arr[i][j]==0) return 0;// Road blocked
        if (arr[i][j]==-1) return 0;// Already visited

        if (i==r && j==c) {
            System.out.println(str);
            return 1;
        }


        arr[i][j]=-1;// This road is visited so block the road.

        int p=0,q=0,l=0,s=0;

        p = totalPathInMaze(arr,i,j+1,r,c,str+"R");
        q = totalPathInMaze(arr,i+1,j,r,c,str+"D");
        l = totalPathInMaze(arr,i,j-1,r,c,str+"R");
        s = totalPathInMaze(arr,i-1,j,r,c,str+"D");

        //Backtracking-At the time of returning we have to make path clear for other rats.
        //Because in java one array is traversing in whole recursion.
        arr[i][j]=1;

        return p+q+l+s;
    }

    static int PossiblePath(boolean[][] arr,int i,int j,int n,int m,String str)
    {

        if (i<0 || j<0) return 0;

        if (i>n || j>m) return 0;

        if (arr[i][j]) return 0;

        if (i==n && j==m)
        {
            System.out.println(str);
            return 1;
        }

        arr[i][j]=true;

        int a=0,b=0,c=0,d=0;

        a = PossiblePath(arr,i,j+1,n,m,str+"R");

        b = PossiblePath(arr,i+1,j,n,m,str+"D");


        c = PossiblePath(arr,i-1,j,n,m,str+"U");

        d = PossiblePath(arr,i,j-1,n,m,str+"L");

        arr[i][j]=false;

        return a+b+c+d;
    }

    public static void main(String[] args) {

        int[][] arr = {{1,1,1},
                      {1,1,0},
                      {0,1,1}};
        int r=3,c=3;

        System.out.println(totalPathInMaze(arr,0,0,r-1,c-1,""));
    }
}
