/**
 * Created by JOKER on 7/31/16.
 */
public class Solution66 {
    public static int[] plusOne(int[] digits) {
        int tmp = 0;
        int[] result = new int[digits.length];
        if(digits.length == 0) return result;
        for(int i=digits.length-1;i>=0;i--){
            tmp = digits[i]+1;
            if(tmp == 10){
                digits[i] = 0;
            }else{
                digits[i]++;
                break;
            }
            if(i==0){
                tmp = 100;
            }
        }
        if(tmp == 100){
            result = new int[digits.length+1];
            result[0] = 1;
            for(int i=1;i<result.length;i++){
                result[i] = digits[i-1];
            }
        }else{
            for(int i=0;i<result.length;i++){
                result[i] = digits[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {0};
        plusOne(digits);
    }
}
