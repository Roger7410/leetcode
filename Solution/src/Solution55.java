/**
 * Created by JOKER on 7/29/16.
 */
public class Solution55 {
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int tmp = 1;
        for(int i = nums.length-2; i >= 0; i--){
            if(tmp != 1){
                if(nums[i] >= tmp){
                    tmp = 1;
                }else{
                    tmp++;
                }
            }else if(nums[i] == 0){
                tmp++;
                //continue;
            }
        }
        return tmp==1;
    }


    public static void main(String[] args) {
        int[] array = {1,0};
        System.out.println(canJump(array));
    }
}
