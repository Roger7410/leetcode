/**
 * Created by JOKER on 7/30/16.
 */
public class Solution165 {
    public static int compareVersion(String version1, String version2) {
//        String[] s1 = version1.split("\\.");
//        String[] s2 = version2.split("\\.");
//        if(s1[0].compareTo(s2[0]) > 0){
//            return 1;
//        }else if(s1[0].compareTo(s2[0]) < 0){
//            return -1;
//        }else{
//            if(s1[1].compareTo(s2[1]) > 0){
//                return 1;
//            }else if(s1[1].compareTo(s2[1]) < 0){
//                return -1;
//            }else{
//                return 0;
//            }
//        }
        //compareTo XXXX
        char[] array1 = version1.toCharArray();
        char[] array2 = version2.toCharArray();
        for(int i=0,j=0;i<array1.length||j<array2.length;i++,j++){
            int v1 = 0;
            int v2 = 0;
            while(i<array1.length && array1[i]!='.'){
                char cur = array1[i++];
                v1 *= 10;
                v1 += (cur - '0');
            }
            while(j<array2.length && array2[j]!='.'){
                char cur = array2[j++];
                v2 *= 10;
                v2 += (cur - '0');
            }
            if(v1>v2) return 1;
            else if(v1<v2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "1212";
        String s2 = "1212.1";
        System.out.println(compareVersion(s1,s2));

//        String s1 = "abc";
//        String s2 = "abc";
////        if(s1.equals(s2)){
////            System.out.println("hi");
////        }
//        String str1 = new String("java");
//        String str2 = new String("java");
//        System.out.println(str1.intern() == str2.intern());
        //System.out.println(compareVersion(s1,s2));
//        System.out.println(s1==s2);
    }
}
