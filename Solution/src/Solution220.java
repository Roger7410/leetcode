/**
 * Created by JOKER on 7/21/16.
 */
public class Solution220 {
    TreeNode root = null;
    boolean flag = false;

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                root = delete(root, nums[i - k - 1]);
            }
            root = insert(root, nums[i], t);
            if (flag) return true;
        }

        return false;
    }


    public TreeNode insert(TreeNode root, int num, int t) {
        if (root == null) {
            TreeNode curNode = new TreeNode(num);
            return curNode;
        }

        if (Math.abs((long) (root.val - num)) <= t) {
            flag = true;
            return root;
        }

        if (root.val < num) {
            root.right = insert(root.right, num, t);
        } else if (root.val > num) {
            root.left = insert(root.left, num, t);
        }

        return root;
    }

    public TreeNode delete(TreeNode root, int num) {
        if (root == null) return null;

        if (root.val < num) {
            root.right = delete(root.right, num);
        } else if (root.val > num) {
            root.left = delete(root.left, num);
        } else {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                //this sense that left and right is none null
                //this is a easy method to deal with it.
                //that exchange the root val with the min or max node
                root.val = findMin(root.right).val;
                root.right = delete(root.right, root.val);
            }
        }

        return root;
    }

    public TreeNode findMin(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    class TreeNode {
        /**
         * 数节点值
         */
        public int val;
        /**
         * 左子树
         */
        public TreeNode left;
        /**
         * 右子树
         */
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}