/**
 * Created by JOKER on 7/30/16.
 */
public class Solution148 {
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid  = null;
        while(fast!=null && fast.next!=null){
            mid  = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //cut the list into 2 parts
        mid.next = null;
        ListNode left  = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode result  = new ListNode(0);
        ListNode current = result;
        while(left!=null && right!=null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if(left!=null){
            current.next = left;
        }
        if(right!=null){
            current.next = right;
        }
        return result.next;
    }
}
