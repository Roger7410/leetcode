/**
 * Created by JOKER on 7/26/16.
 */
public class Solution38 {
    public static String countAndSay(int n) {
        String result = "1";
        int count = 1;
        if( n < 1 ) return null;
        if( n == 1 ) return result;
        for(int i = 2; i <=n; i++){
            //from 2nd to nth
            StringBuilder tmp = new StringBuilder();//builder efficient not thread safe ;buffer safe not effi
            for(int j=0; j<result.length(); j++){
                if( j == result.length() - 1 ){
                    tmp.append(count);
                    tmp.append(result.charAt(j));
                    count = 1;
                }else {
                    if (result.charAt(j) == result.charAt(j + 1)) {
                        count++;
                    } else {
                        tmp.append(count);
                        tmp.append(result.charAt(j));
                        count = 1;
                    }
                }
            }
            result = tmp.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(7));
    }
}
