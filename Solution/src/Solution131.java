import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public static List<List<String>> result;
    public static List<String> current;

    public static List<List<String>> partition(String s) {
        result = new ArrayList<>();
        current= new ArrayList<>();
        backTrack(s,0);
        return result;
    }

    public static void backTrack(String s,int l){
        if(l >= s.length() && current.size()!=0){
            List<String> r = new ArrayList<>(current);
            result.add(r);
        }
        for(int i = l; i<s.length(); i++){
            if(isPalindrome(s,l,i)){//if from l to i is palindrome
                current.add(s.substring(l,i+1));//add tmp
                backTrack(s,i+1);
                current.remove(current.size()-1);//remove the last one
            }
        }

    }

    public static boolean isPalindrome(String s, int start, int end){
        while(start<end){//if start = end return true
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }
}
