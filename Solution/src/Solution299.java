import java.util.HashMap;
import java.util.Map;

/**
 * Created by JOKER on 7/31/16.
 */
public class Solution299 {
    public static String getHint(String secret, String guess) {
        if(secret.length() == 0){
            return "0A0B";
        }
        int bulls = 0;
        int cows  = 0;
        HashMap<Character,Integer> sec = new HashMap<>();
        HashMap<Character,Integer> gus = new HashMap<>();
        for(int i = 0;i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                bulls++;
            }else{
                if(!sec.containsKey(s)){
                    sec.put(s,1);
                }else{
                    sec.put(s,sec.get(s)+1);
                }
                if(!gus.containsKey(g)){
                    gus.put(g,1);
                }else{
                    gus.put(g,gus.get(g)+1);
                }
            }
        }
        int count = 0;
        for(Map.Entry<Character,Integer> tmp: sec.entrySet()){
            char key = tmp.getKey();
            int value= tmp.getValue();
            if(gus.containsKey(key)){
                count = Math.min(value,gus.get(key));
                cows += count;
            }
        }
        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println(getHint(s1,s2));
    }
}
