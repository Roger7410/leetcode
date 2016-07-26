import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JOKER on 7/17/16.
 */
public class Solution202 {
    public static void main(String[] args) {
        System.out.println(Math.pow(9, 2));
    }
    public boolean isHappy(int n) {
        //HashMap<Integer,Boolean> exist = new HashMap<>();
        List<Integer> array = new ArrayList<>();

        while(true) {
            if( n == 1) return true;
            int temp = 0;
            while (n % 10 != 0 || n/10 != 0) {
                temp = temp + (int) Math.pow((n % 10), 2);
                n = n / 10;
            }
            if(array.contains(temp)){
                return false;
            }else{
                array.add(temp);
            }
            n = temp;
        }
    }




}
