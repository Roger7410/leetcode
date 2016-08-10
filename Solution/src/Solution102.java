import java.util.*;

/**
 * Created by JOKER on 8/9/16.
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(tmpList);
        }
        return result;
    }
}
