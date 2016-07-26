import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JOKER on 7/20/16.
 */
public class Solution349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {};
        int[] result = intersection(nums1,nums2);
        for(int i: result){
            System.out.println(i);
        }
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int num: nums1){
            if(!list.contains(num)){
                list.add(num);
            }
        }
        for(int num2: nums2){
            if(list.contains(num2) && !list2.contains(num2)){
                list2.add(num2);
            }
        }
        int[] result = new int[list2.size()];
        int add = 0;
        for(int i : list2){
            result[add] = i;
            add++;
        }
        return result;
    }
}
