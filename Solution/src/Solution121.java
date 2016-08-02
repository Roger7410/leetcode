/**
 * Created by JOKER on 7/31/16.
 */
public class Solution121 {
    public static int maxProfit(int[] prices){
        if(prices.length == 1 || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int maxdiff = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
            }
            if(prices[i]-min>maxdiff){
                maxdiff = prices[i]-min;
            }
        }
        return maxdiff;
    }

    public static void main(String[] args) {
        int[] test = {};
        System.out.println(maxProfit(test));
    }
}
