package HashMap;
import java.util.*;
import java.util.HashSet;



public class HashMapQ2 {

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        
        int maxSize = 0;
        int prefSum = 0;
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        mp.put(0,-1);
        
        for(int i=0;i<N;i++){
            
            prefSum+=A[i];
            
            if(mp.containsKey(prefSum-K)){
    
                maxSize = Math.max(maxSize,i-mp.get(prefSum-K));

            }
            
            if (!mp.containsKey(prefSum)) 
                mp.put(prefSum,i);
        }
        
        return maxSize;
    }

    //Ek number ko nikal kar check kijiye ki kya uska pair hashset me hai. yadi nahi hai to hashset me daliye
    //yadi hai to remove kar dijiye. ye sab karne me apne pure samay me hashset me max kitne num daale the?
    public static void main(String[] args) {

        int[] arr = {2,1,1,3,2,3};
        int size=0;
        int max=0;

        HashSet<Integer> set = new HashSet<>();

        for(int x:arr)
        {
            if (!set.contains(x)){
                set.add(x);
                size++;
            }else {
                set.remove(x);
                size--;
            }

            max = max<size?size:max;
        }
        System.out.println(max);
        
    }
}
