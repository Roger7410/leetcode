import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution113 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> tmpList = new ArrayList<>();
        if (root == null){
            return null;
        }
        tmpList.add(root.val);
        int current = sum - root.val;
        if( current == 0 ){
            if( root.left == null && root.right == null){
                //flag = true;
                result.add(tmpList);
                return null;
            }else{
                pathSum(root.left, current);
                pathSum(root.right,current);
                tmpList.remove(root.val);
            }
        }else{
            pathSum(root.left, current);
            pathSum(root.right,current);
            tmpList.remove(root.val);
        }
        return result;
    }
}