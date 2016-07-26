import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by JOKER on 7/21/16.
 */
public class Solution217 {
    public static void main(String[] args) {
        int[] array = {0};
        System.out.println(containsNearbyDuplicate(array,1));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        //deal with the first k
        int length = nums.length;
        for(int i = 0; i<k; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        for(int i=k; i< length; i++){
            set.remove(nums[i-k]);
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;

    }
}
