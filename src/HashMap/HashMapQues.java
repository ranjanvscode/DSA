package HashMap;
import java.util.*;

public class HashMapQues {
    //brute force approach for anagram
    private static char[] sort(char[] ch)
    {
        for (int i=0;i<ch.length;i++){
            for (int j=1;j<ch.length-i;j++)
            {
                if (ch[j-1]>ch[j])
                {
                    char chr = ch[j-1];
                    ch[j-1] = ch[j];
                    ch[j] = chr;
                }
            }
        }
        return ch;
    }

    public static boolean anagram(String s1, String s2)
    {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        if (s1.length()==s2.length())
        {
            s1 = String.valueOf(sort(ch1));
            s2 = String.valueOf(sort(ch2));

//            System.out.println(s1);
//            System.out.println(s2);

            if (s1.equals(s2))
                return true;
            else
                return false;
        }

        return false;
    }

    //using HashMap for anagram
    public static boolean anagram2(String s1, String s2){

        if (s1.length()!=s2.length()) return false;

        HashMap<Character,Integer> hp = new HashMap<>();

        for (int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);

            if (hp.containsKey(ch)){
                hp.put(ch,hp.get(ch)+1);
            }else {
                hp.put(ch,1);
            }

        }

        for (int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);

            if (hp.containsKey(ch)){

                if (hp.get(ch)==1)
                    hp.remove(ch);
                else
                    hp.put(ch,hp.get(ch)-1);
            }else {
                return false;
            }

        }

        return hp.isEmpty();
    }

    //Isomorphic word

    public static boolean isomorphic(String s1, String s2){

        if (s1.length()!=s2.length()) return false;

        HashMap<Character,Character> hp = new HashMap<>();

        for (int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);

            if (hp.containsKey(ch1)){
                if (hp.get(ch1)!=ch2)
                    return false;
            }else if (hp.containsValue(ch2)){ //T.C of containsValue is o(n).
                return false;
            }else {
                hp.put(ch1,ch2);
            }
        }

        return true;
    }

    //Two sum 
    public static int[] twoSum(int[] arr,int target)
    {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n=arr.length;
        

        for(int i=0;i<n;i++){

            int lostNum = target - arr[i];

            if (mp.containsKey(lostNum)) {
                
                return new int[]{arr[i],lostNum};
            }

            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i], i);
            }
        }

        return new int[]{-1};
    }
    public static void main(String[] args) {

    //    String str1 = "AABBBCCCDD";
    //    String str2 = "XXYYYBBBXX";

    //   System.out.println("Anagram: "+ anagram2(str1,str2));
    //    System.out.println("Isomorphic: "+ isomorphic(str1,str2));


    int[] arr = {1,2,3,2,6,8,3,4,9,6,4,5,6,7,8,9};

    System.out.println(Arrays.toString(twoSum(arr,28)));

    }
}
