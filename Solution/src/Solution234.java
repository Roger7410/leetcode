/**
 * Created by JOKER on 7/27/16.
 */
public class Solution234 {
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        int count = 1;
        ListNode countNode = head;
        while(countNode.next!=null){
            count++;
            countNode=countNode.next;
        }
        if(count ==1){
            return true;
        }
        if(count % 2 != 0){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while( fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHalf = slow.next;
        //reverse head to slow
        ListNode next;
        ListNode prev = null;
        while(head != rightHalf){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        while(rightHalf != null){
            if(prev.val!=rightHalf.val){
                return false;
            }
            prev = prev.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));
    }
}
