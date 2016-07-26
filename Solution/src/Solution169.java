import java.util.HashMap;
import java.util.Map;

/**
 * Created by JOKER on 7/20/16.
 */
public class Solution169 {
    public static int majorityElement(int[] nums) {
        // if(nums.length == 1) return nums[0];
        // Arrays.sort(nums);
        // return nums[nums.length/2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry ele: map.entrySet()){
            if((int)(ele.getValue())>=nums.length/2+1)
                return (int)ele.getKey();
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] array = {3,2,3};
        System.out.println(majorityElement(array));
    }
}
