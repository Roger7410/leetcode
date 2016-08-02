/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //store head
        ListNode curr = head;
        //store before m
        ListNode beforeM = null;
        for(int i =0; i<m-1; i++){
            beforeM=curr;
            curr=curr.next;
        }
        //store after n
        ListNode afterN = curr;
        for(int j =0; j<n-m+1;j++){
            afterN=afterN.next;
        }
        //reverse m -> n
        ListNode next;
        ListNode prev = afterN;
        for(int k =0; k<n-m+1;k++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (beforeM != null) {
            beforeM.next = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseBetween(head,2,3);
    }
}