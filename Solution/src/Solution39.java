import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        int start = 0;
        helper(result,new ArrayList<Integer>(),candidates,target,sum,start);
        return result;

    }
    public void helper(List<List<Integer>> result, List<Integer> tmp,
                       int[] candidates, int target, int sum, int start){
        if(sum == target){
            List<Integer> tmpp = new ArrayList<Integer>(tmp);
            result.add(tmpp);
        }
        else if(sum > target){

        }else{
            for(int i = start; i<candidates.length; i++){
                tmp.add(candidates[i]);
                helper(result,tmp,candidates,target,sum+candidates[i],i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}