///**
// * Created by JOKER on 7/30/16.
// */
//public class Solution {
//    public void connect(TreeLinkNode root) {
//        if(root == null){
//            return;
//        }
//        TreeLinkNode leftMost = null;
//        while(root != null){
//            if(root.left != null){
//                leftMost = root.left;
//                break;
//            }
//            else if(root.right != null){
//                leftMost = root.right;
//                break;
//            }
//            root = root.next;
//        }
//        TreeLinkNode dummy = new TreeLinkNode(0);
//        if(leftMost!=null){
//            while(root != null){
//                if(root.left != null){
//                    dummy.next = root.left;
//                    dummy = dummy.next;
//                }
//                if(root.right != null){
//                    dummy.next = root.right;
//                    dummy = dummy.next
//                }
//                root = root.next;
//            }
//        }
//        root = leftMost;
//    }
//}
