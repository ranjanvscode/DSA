import java.util.ArrayList;

public class Subset {

    public static void subset(int[] arr, int index, ArrayList<Integer> tempArr)
    {
        if (index == arr.length)
        {
          if (!tempArr.isEmpty())
           System.out.println(tempArr);

          return;
        }


        subset(arr,index+1,tempArr);
        tempArr.add(arr[index]);

        subset(arr,index+1,tempArr);
        tempArr.remove(tempArr.size()-1);
    }

    //Find the max non-negative contineous sub array if sum of two sub-array is equal
    //then return longest sub array.
    public static ArrayList<Integer> findSubArray(int a[], int n) {
        // code here
        
        ArrayList<Integer>[] list = new ArrayList[n];
        int x=0;
        int[] sumArr = new int[n];
        list[x] = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            if(a[i]>=0){
                
                list[x].add(a[i]);
                sumArr[x]+=a[i];
                
            }else if(i>0 && a[i-1]>=0){
                
                x++;
                list[x] = new ArrayList<>();
            }
        }

        x=0;
        int max=sumArr[0];
        for(int i=1;i<10;i++){
            if (max<sumArr[i]) {
                max=sumArr[i];
                x=i;
            }else if(max==sumArr[i]){

                if (list[x].size()<list[i].size()) {

                    x=i;

                }else if (list[x].size()==list[i].size()){

                        if(list[x].get(0)>list[i].get(0))
                            x=i;
                        else  if(list[x].get(0)==list[i].get(0))
                        return new ArrayList<>(){{add(-1);}};
                }
            }
        }

        return list[x];
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3
        };

        subset(arr,0,new ArrayList<>());

    }
}