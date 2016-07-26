/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution104 {
    public static int max = 0;
    public static int count = 0;
    public static int maxDepth(TreeNode root) {
        count++;
        if(root == null){
            count--;
            if( count >= max) {
                max = count;
            }
            //return max;
        }else {
            if (root.left == null && root.right == null) {
                if(count > max){
                    max = count;
                }
                count--;
            } else {
                maxDepth(root.left);
                maxDepth(root.right);
                count--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        System.out.println(maxDepth(root));
    }
}