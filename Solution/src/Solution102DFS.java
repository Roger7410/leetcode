import java.util.ArrayList;
import java.util.List;

/**
 * Created by JOKER on 8/9/16.
 */
public class Solution102DFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    private void levelHelper(List<List<Integer>> result, TreeNode root, int level){
        if(root == null) return;
        if(level >= result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelHelper(result,root.left,level+1);
        levelHelper(result,root.right,level+1);
    }
}
