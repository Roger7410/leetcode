/**
 * Created by JOKER on 7/25/16.
 */
public class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        boolean flag = false;
        int[] result = {-1,-1};
        for(int num: nums){
            result[0]++;
            result[1]++;
            if(num == target) {
                flag = true;
                break;
            }
        }
        if(flag){
            for(;result[1]+1<nums.length;){
                if(nums[result[1]+1] != target){
                    break;
                }
                result[1]++;
            }
        }else{
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {5,7,7,8,8,10};
        int[] test2 = {};
        System.out.println(searchRange(test,8)[0]);
        System.out.println(searchRange(test,8)[1]);
        System.out.println(searchRange(test2,0)[0]);
        System.out.println(searchRange(test2,0)[1]);
    }
}
