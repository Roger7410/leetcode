import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JOKER on 8/6/16.
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(result, new ArrayList<>(), nums, 0);
        return result;
    }
    public void backTracking(List<List<Integer>> list, List<Integer> tmp_list,
                             int[] nums, int start){
        list.add(new ArrayList<>(tmp_list));
        for(int i = start; i < nums.length; i++){
            if( i > start && nums[i] == nums[i-1]){
                continue;
            }
            tmp_list.add(nums[i]);
            backTracking(list,tmp_list,nums,i+1);
            tmp_list.remove(tmp_list.size()-1);
        }
    }
}
