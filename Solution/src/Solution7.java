/**
 * Created by JOKER on 7/31/16.
 */
public class Solution7 {
    public static int reverse(int x){
        int r = 0;
        while(x!=0){
            r = r*10 + x % 10;
            x = x/10;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
        System.out.println(Integer.MAX_VALUE);
    }
}
