import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by JOKER on 7/29/16.
 */
public class Solution345 {
    public static String reverseVowels(String s) {
        //two pointers
        HashSet<Character> vowels = new HashSet<>();
        char[] ss = s.toCharArray();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int p1 = 0;
        int p2 = ss.length-1;
        char temp;
        while(p2 > p1){
            while(!vowels.contains(ss[p1])){//change this to a for loop to make it more efficent
                p1++;//p1>=p2 break
                if(p1>=p2) break;
            }
            while(!vowels.contains(ss[p2])){
                p2--;//p1>=p2 break
                if(p1 >= p2) break;
            }
            if(p1>=p2) break;
            temp = ss[p1];
            ss[p1] = ss[p2];
            ss[p2] = temp;
            p1++;
            p2--;
        }
        String result = new String(ss);
        return result;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
