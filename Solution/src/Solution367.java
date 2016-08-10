/**
 * Created by JOKER on 8/9/16.
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
//        long r = num;
//        while(r*r > num){
//            r = (r + num/r)/2;
//        }
//        return r*r == num;
        long start = 0, end = num/2;
        long mid = start + (end-start)/2;
        if (num == 1){
            return true;
        }
        long nums = (long) num;
        while(end >= start){
            mid = start + (end-start)/2;
            if(mid * mid == nums){
                return true;
            }else if(mid * mid > nums){
                end = mid - 1;
            }else if(mid * mid < nums){
                start = mid +1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution367 test = new Solution367();
        System.out.println(test.isPerfectSquare(9));
    }
}
