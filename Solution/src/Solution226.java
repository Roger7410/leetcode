/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution226 {
    public static TreeNode tmp;
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    public static void helper(TreeNode current){
        if(current.left != null && current.right!= null){
            tmp = current.right;
            current.right = current.left;
            current.left = tmp;
            helper(current.left);
            helper(current.right);
        }
        else if(current.left != null){
            current.right = current.left;
            current.left = null;
            helper(current.right);
        }
        else if(current.right!= null){
            current.left = current.right;
            current.right = null;
            helper(current.left);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        invertTree(root);
        System.out.println("a");
    }
}