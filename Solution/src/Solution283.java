/**
 * Created by JOKER on 7/20/16.
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int p0 = 0;//find 0
        int p1 = 0;//find !0'
        while(true){
            while(p0<nums.length && nums[p0] != 0)
                p0++;
            while(p1<nums.length && nums[p1] == 0)
                p1++;
            if(p0 >= nums.length || p1>= nums.length)
                break;
            if(p1>p0 && nums[p1]!=0){
                nums[p0] = nums[p1];
                nums[p1] = 0;
            }
            p1++;
        }

    }

    public static void main(String[] args) {
        int[] array = {0,0};
        moveZeroes(array);
        for(int i : array){
            System.out.println(i);
        }
    }
}
