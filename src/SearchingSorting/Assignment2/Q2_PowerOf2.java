package SearchingSorting.Assignment2;

import java.util.Scanner;

public class Q2_PowerOf2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int num= sc.nextInt();
        int r=0;
        boolean flag=true;

        while (r==0)
        {
            r=num%2;
            num=num/2;

            if(r!=0 || num==0) flag = false;
            if(num<=1) break;

        }

        System.out.println(flag);

    }
}
