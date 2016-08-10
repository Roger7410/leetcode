/**
 * Created by JOKER on 8/9/16.
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int result = 0;
        //the last digit
        result += s.charAt(s.length()-1) - 'A' + 1;
        int digit = 1;
        for(int i = s.length()-2; i >= 0; i--){
            result += (s.charAt(i) - 'A' + 1)*Math.pow(26,digit);
            digit++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(3,2));
        Solution171 test = new Solution171();
        System.out.println(test.titleToNumber("AAA"));
    }
}
