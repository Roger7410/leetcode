

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution143 {
    public static void reorderList(ListNode head) {
        //There are 3 steps for this question
        //1 find middle
        //reverse right half part
        //insert
        if(head == null || head.next == null){
            return;
        }
        //find the middle
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }
        //reverse right part
        //from slow to end
        ListNode curr = slow;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //merge head to mid and prev to end
        curr = head;
        ListNode prevNext = null;
        ListNode currNext = null;
        while(curr.next!=null && prev!=null){
            currNext = curr.next;
            prevNext = prev.next;
            curr.next = prev;
            prev.next = currNext;
            prev = prevNext;
            curr = currNext;
        }

    }

    public static void main(String[] args) {

    }
}