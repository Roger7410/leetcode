import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> rList = new ArrayList<>();
        int same;
        int count = 0;
        //int index = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int num: nums1){
            if(!map1.containsKey(num)){
                map1.put(num,1);
            }else{
                map1.put(num,map1.get(num)+1);
            }
        }
        for(int num: nums2){
            if(!map2.containsKey(num)){
                map2.put(num,1);
            }else{
                map2.put(num,map2.get(num)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()){
            same = entry.getKey();
            if(map2.containsKey(same)){
                count = Math.min(map1.get(same),map2.get(same));
            }
            for(int i = 0; i<count; i++){
                rList.add(same);
            }
            count = 0;
        }
        int[] result = new int[rList.size()];
        for(int i = 0; i<rList.size(); i++){
            result[i] = rList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        int[] result = intersect(nums1,nums2);
        for(int num: result){
            System.out.println(num);
        }
    }
}
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> temp = new ArrayList<Integer>();
//        for (int num : nums1)
//            map.put(num, map.getOrDefault(num, 0)+1);
//        for (int num : nums2){
//            if (map.containsKey(num) && map.get(num) > 0){
//                temp.add(num);
//                map.put(num, map.get(num)-1);
//            }
//        }
//        int[] res = new int[temp.size()];
//        for (int i = 0; i < temp.size(); i++)
//            res[i] = temp.get(i);
//        return res;
//    }
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        List<Integer> temp = new ArrayList<Integer>();
//        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;){
//            if (nums1[i] < nums2[j]) i++;
//            else if (nums1[i] > nums2[j]) j++;
//            else {
//                temp.add(nums1[i]);
//                i++; j++;
//            }
//        }
//        int[] res = new int[temp.size()];
//        for (int i = 0; i < temp.size(); i++)
//            res[i] = temp.get(i);
//        return res;
//    }
