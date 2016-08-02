/**
 * Created by JOKER on 7/30/16.
 */
public class Solution35 {
    public static int candy(int[] ratings){
        if(ratings.length == 0){
            return 0;
        }else if(ratings.length == 1){
            return 1;
        }
        int[] candyNums = new int[ratings.length];
        candyNums[0] = 1;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){//if next > last next = last +1
                candyNums[i] = candyNums[i-1] + 1;
            }else if(ratings[i] < ratings[i-1]){//if next < last next = last - 1
                if(candyNums[i-1] == 1){
                    int tmp = i-1;
                    candyNums[tmp]++;
                    if(tmp != 0) {
                        while (ratings[tmp] < ratings[tmp - 1]) {
                            if(candyNums[tmp-1]>candyNums[tmp])
                                break;
                            candyNums[tmp - 1]++;
                            tmp--;
                            if (tmp == 0) break;
                        }
                    }
                }
                candyNums[i] = 1;
            }else{//next == last
                candyNums[i] = 1;
            }
        }
        int min = candyNums[0];
        int sum = 0;
        for(int num: candyNums){
            if(num<min) min = num;
            sum += num;
        }
        sum = sum - (min-1) * candyNums.length;
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,3,4,3,2,1};
        System.out.println(candy(ratings));
    }
}
