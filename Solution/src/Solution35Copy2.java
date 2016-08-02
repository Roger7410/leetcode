/**
 * Created by JOKER on 7/30/16.
 */
public class Solution35Copy2 {
    public static int candy(int[] ratings){
        int length = ratings.length;
        if(length<=1){
            return length;
        }
        int[] candyNums = new int[length];
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1]){
                candyNums[i] = candyNums[i-1]+1;
            }
        }
        for(int i=length-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                candyNums[i-1] = Math.max(candyNums[i]+1,candyNums[i-1]);
            }
        }
        int result = 0;
        for(int num: candyNums){
            result+=num;
        }
        return result+length;
    }
}
