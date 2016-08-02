public class Solution151 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for(int i = array.length-1; i>=0; i--){
            if(!array[i].equals("")){
                sb.append(array[i]+" ");
            }
        }
        if(sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = " ";
        String result = reverseWords(s);
        System.out.println(result);
    }
}