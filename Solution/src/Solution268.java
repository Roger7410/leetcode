

/**
 * Created by JOKER on 7/17/16.
 */
public class Solution268 {
    public static int missingNumber(int[] nums) {
        int miss = -1;
        // 0,1,2,3,4,5,6,7,8,9
        int[] helpArray = {0,1,2,3,4,5,6,7,8,9};
        //nums nod helpArray
        int helpAdd = 0;
        for (int i=0; i<nums.length; i++){

            if((nums[i] - helpArray[helpAdd])%10 != 0){
                miss = i;
                break;
            }
            helpAdd++;
            if(helpAdd>=10){
                helpAdd = helpAdd - 10;
            }
        }
        if(miss == -1){
            miss = nums.length;
        }
        return miss;
    }

    public static void main(String[] args) {
        System.out.println(4^6);
    }
}
