import java.util.*;

/**
 * Created by JOKER on 7/16/16.
 */
public class Solution347 {


    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        //find max frequency
        int max = 0;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            max = Math.max(max,(Integer)entry.getValue());
        }
        //initialize an array of arraylist
        //index is frequency , values are the nums
        ArrayList<Integer>[] list = new ArrayList[max+1];
        for(int i=1; i<=max; i++){
            list[i]=new ArrayList<>();
        }
        //better way to go through the hashmap
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int frequency = entry.getValue();
            list[frequency].add(num);
        }
        //get result (k)
        List<Integer> result = new ArrayList<>();
        for(int i = max; i>=1; i--){
            if(!list[i].isEmpty()){
                for(int num: list[i]){
                    result.add(num);
                }
            }
            if(result.size() == k){
                break;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1,2,2,3,3,3,3};
        int k = 2;
        List<Integer> result = topKFrequent(nums,k);
        for(int num: result){
            System.out.println(num);
        }
    }
}
