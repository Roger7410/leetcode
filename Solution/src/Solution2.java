/**
 * Created by JOKER on 7/31/16.
 */
public class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head   = result;
        int addTwo = 0;
        int carry  = 0;
        while(l1!=null && l2!=null){
            addTwo = l1.val + l2.val + carry;
            if(addTwo > 9){
                carry = 1;
                addTwo -= 10;
            }else{
                carry = 0;
            }
            head.next = new ListNode(addTwo);
            head = head.next;
            l1   = l1.next;
            l2   = l2.next;
        }
        ListNode more = null;
        ListNode help = null;
        if(l1!=null){
            more = l1;
        }else if(l2!=null){
            more = l2;
        }
        if(more!=null){
            head.next = more;
            while(carry == 1 && more!=null) {
                more.val++;
                if (more.val == 10) {
                    more.val = 0;
                    carry = 1;
                    help = more;
                    more = more.next;
                } else {
                    carry = 0;
                }
            }
            if(carry == 1){
                help.next = new ListNode(1);
                carry = 0;
            }
        }
        if(carry == 1){
            head.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);
    }

}
