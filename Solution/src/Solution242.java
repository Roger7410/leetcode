import java.util.HashMap;
import java.util.Map;

/**
 * Created by JOKER on 7/20/16.
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] temp = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i = 0; i<s.length(); i++){
            temp[s.charAt(i)-'a']++;
        }
        for(int j = 0; j<t.length(); j++){
            temp[t.charAt(j)-'a']--;
            if(temp[t.charAt(j)-'a']<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a'-96);
        String aa = "sjsjsjs";
        System.out.println(aa.charAt(0));
        HashMap<Integer,Integer> map = new HashMap<>();
        map.entrySet();
        int [] a = new int [3];
        for(Map.Entry ele: map.entrySet()){

        }
    }
}
