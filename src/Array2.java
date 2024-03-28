//2D Array Tutorial

import java.util.Scanner;

public class Array2 {

    static void printmatrix(int[][] array,int r,int c)
    {
        for(int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                if (array[i][j]<10)
                {
                    System.out.print("0"+array[i][j] +" ");
                }else {
                    System.out.print(array[i][j] +" ");
                }

            }
            System.out.println();
        }
    }

    static void multip(int[][] arr1,int r1,int c1,int[][] arr2, int r2,int c2)
    {
        if(c1!=r2)
        {
            System.out.println("Wrong Dimension");
            return;
        }

        int[][] mul= new int[r1][c2];

        for(int i=0;i<r1;i++) {
            for (int j = 0; j < c2; j++) {
                for (int k=0;k<c1;k++) {
                mul[i][j]+=(arr1[i][k]*arr2[k][j]);
            }
          }
        }

        printmatrix(mul,r1,c2);
    }

    static void transpose(int[][] matrix,int r,int c)
    {
        int[][] ans=new int[c][r];

        for(int i=0;i<c;i++)
        {
            for (int j=0;j<r;j++)
            {
                ans[i][j]= matrix[j][i];
            }
        }
        printmatrix(ans,c,r);
    }

    static void transposeinsamespace(int[][] matrix,int r,int c)
    {
//        int[][] ans=new int[c][r];

        for(int i=0;i<c;i++)
        {
            for (int j=i+1;j<r;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }

    static void reverse(int[][] matrix,int r,int c)
    {
        int t=c/2;
        for(int i=0;i<r;i++)
        {
            int k=c-1;
            for (int j=0;j<t;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j]= matrix[i][k];
                matrix[i][k]=temp;
                k--;

            }
        }
    }

    static void rotate(int[][] matrix,int r)
    {
        transposeinsamespace(matrix,r,r);
        reverse(matrix,r,r);
    }

    static int[][] pastri(int n)
    {
        int[][] ans = new int[n][];

        for (int i = 0; i < n; i++) {
            ans[i] = new int[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i][0] = ans[i][i]=1;
        }

        for (int i = 1; i < n; i++) {
            for (int j=1;j<i;j++)
            {
                ans[i][j]=ans[i-1][j-1] + ans[i-1][j];
            }
        }
        return ans;

    }

    static void printpastri(int[][] ans,int n)
    {

        for (int i = 0; i < n; i++) {
            for (int j=n;j>i+1;j--)
            {
                System.out.print(" ");
            }
            for (int j=0;j<=i;j++)
            {
                System.out.print( ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void spiralprint(int[][] arr,int br, int rc)
    {
        int tr=0,lc=0,lp=br*rc;
        while(lp>0)
        {
            for(int i=lc;i<rc && lp>0;i++)
            {
                System.out.print(arr[tr][i]+" ");
                lp--;
            }
            tr++;
            for(int i=tr;i<br && lp>0;i++)
            {
                System.out.print(arr[i][rc-1]+" ");
                lp--;
            }
            rc--;
            for(int i=rc-1;i>=lc && lp>0;i--)
            {
                System.out.print(arr[br-1][i]+" ");
                lp--;
            }
            br--;
            for(int i=br-1;i>=tr && lp>0;i--)
            {
                System.out.print(arr[i][lc]+" ");
                lp--;
            }
            lc++;
        }
    }

    static void spiralinput(int[][] arr,int br, int rc)
    {
        int tr=0,lc=0,lp=br*rc;
        int curr=1;
        while(lp>0)
        {
            for(int i=lc;i<rc && lp>0;i++)
            {
//               System.out.print(arr[tr][i]+" ");
                arr[tr][i]=curr;
                curr++;
                lp--;
            }
            tr++;
            for(int i=tr;i<br && lp>0;i++)
            {
//                System.out.print(arr[i][rc-1]+" ");
                arr[i][rc-1]=curr;
                curr++;
                lp--;
            }
            rc--;
            for(int i=rc-1;i>=lc && lp>0;i--)
            {
//                System.out.print(arr[br-1][i]+" ");
                arr[br-1][i]=curr;
                curr++;
                lp--;
            }
            br--;
            for(int i=br-1;i>=tr && lp>0;i--)
            {
//                System.out.print(arr[i][lc]+" ");
                arr[i][lc]=curr;
                curr++;
                lp--;
            }
            lc++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows or column number of matrix:");
        int n= sc.nextInt();
        int[][] arr = new int[n][n];
        spiralinput(arr,n,n);
        printmatrix(arr,n,n);

         /*System.out.println("Enter dimension of first array");
        int r1= sc.nextInt();
        int c1= sc.nextInt();
        int[][] arr1 = new int[r1][c1];

       System.out.println("Enter Value in first array");
        for(int i=0;i<r1;i++)
        {
            for (int j=0;j<c1;j++)
            {
                arr1[i][j]= sc.nextInt();
            }
        }*/ //First array input


        /*System.out.println("Enter dimension of second array");
        int r2= sc.nextInt();
        int c2= sc.nextInt();
        int[][] arr2 = new int[r2][c2];

        System.out.println("Enter Value in second array");
        for(int i=0;i<r2;i++)
        {
            for (int j=0;j<c2;j++)
            {
                arr2[i][j]= sc.nextInt();
            }
        }*/ //Second array input

        /*System.out.println("How many times you want to rotate?");
        int count = sc.nextInt();
        while (count>0)
        {
            rotate(arr1,r1);
            printmatrix(arr1,r1,r1);
            System.out.println();
            count--;
        }*/ //run rotate code

       /* System.out.println("Enter number of rows of pascle triangle:");
        int n = sc.nextInt();
        int[][] ans = pastri(n);
        printpastri(ans,n);*/ //Pascle Triangle

//        int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};




    }
}
