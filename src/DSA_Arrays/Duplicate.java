package DSA_Arrays;

public class Duplicate {
    public static void main(String[] args) {

        int[] arrr = {2,5,6,4,7,8,5,4,5,2,6,10};

        int count=1;
        int l= arrr.length;

        for (int i=0;i< l-1;i++)
        {
            for (int t=i-1;t>=0;t--)
            {
                if (arrr[i]==arrr[t])
                {
                    count=-1;
                    break;
                }
            }

            for(int j=i+1;j<l;j++)
            {
               if (count==-1) break;

               if (arrr[i]==arrr[j])
               {
                   count++;
               }
            }
            if (count>1)
            {
                System.out.println("Duplicate no   - " + arrr[i]);
                System.out.println("How many times - " + count);
                System.out.println();
            }
            count=1;
        }

    }
}
