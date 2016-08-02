/**
 * Created by JOKER on 7/30/16.
 */
public class Solution168 {
    public static String convertToTitle(int n) {
        String title = "";
        while(n>0){
            n--;
            title = (char)('A'+ n%26) + title;
            n /= 26;
        }
        return title;
    }

    public static void main(String[] args) {
        int n = 52;
        System.out.println(convertToTitle(n));
    }
}
