/**
 * Created by JOKER on 7/30/16.
 */
public class Solution35Copy {
    public int candy(int[] ratings){
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int total = 1, current = 1, count = 0;
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>=ratings[i-1]){
                if(count>0){
                    total += (count+1)*count/2;
                    if(count>=current){
                        total+=count-current+1;
                    }
                    current = 1;
                    count = 0;
                }
                current = ratings[i] == ratings[i-1] ? 1 : current+1;
                total += current;
            }else{
                count++;
            }
        }
        //if last part is desc
        if(count>0){
            total += (count+1)*count/2;
            if(count>=current){
                total+=count-current+1;
            }
        }
        return total;
    }
}
