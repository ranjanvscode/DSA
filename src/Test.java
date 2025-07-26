
import java.math.BigInteger;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test
{
    public static int maxArea(int[] height) {

        int l=height.length;
        int maxArea=0;
        int area=0;
        int left=0;
        int right=l-1;

        while (left<=right){

            area = (right-left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,area);

            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }

// User function Template for Java

    class Solution {
        static ArrayList<Integer> factorial(int n){
            ArrayList<Integer>factorial = new ArrayList<>();
            factorial.add(1);

            int carry = 0;
            for(int num = 2 ; num <= n ; num++){
                for(int i=factorial.size()-1;i>= 0;i--){
                    int product=(factorial.get(i) * num) + carry;
                    carry = product / 10;
                    factorial.set(i,product % 10);
                }

                while(carry != 0){
                    factorial.add(0,carry%10);
                    carry=carry/10;
                }
            }

            return factorial;
        }
    }
        public static void fact() {
            int n = 100;
            BigInteger factorial = BigInteger.ONE;

            for (int i = 2; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }

            System.out.println("Factorial of " + n + " is: " + factorial);


        }

        static void pascalTriangle(){
            int[][] tri = new int[5][];

            for (int i=0;i<5;i++)
            {
                tri[i] = new int[i+1];

                for (int j=5;j>i;j--){

                    System.out.print(" ");
                }
                for (int j=0;j<=i;j++){

                    if (j==0 || j==i){
                        tri[i][j] = 1;
                    }else {

                        tri[i][j] = tri[i-1][j-1]+tri[i-1][j];
                    }

                    System.out.print(tri[i][j]+" ");
                }

                System.out.println();

            }
        }



    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};

        int a=12;
        int b = 23;

        while (b!=0){
            int carry = (a&b);
            a = a^b;
            b = carry << 1;
        }



    }
}