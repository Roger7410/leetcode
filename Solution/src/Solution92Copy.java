/**
 * Created by JOKER on 7/27/16.
 */
public class Solution92Copy {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = null;
        ListNode last = null;
        ListNode pre = null;
        ListNode hd = head;//Always copy a head for later use in ListNode preblem

        for(int i = 1; i <= n; i++)
        {
            if(i == m - 1)//find the previous node
                pre = hd;
            else if(i == m)//find the first node
                first = hd;
            if(i == n)//find the last node, it does not matter if n == m
            {
                last = hd;
                break;//   after finding the last node, we can stop
            }
            hd = hd.next;//move to next
        }

        ListNode curr = first.next;
        hd = head;
        if(pre == null)//if pre == null, which means m == 1, the head node after reverse should be the last node in [m,n]
            head = last;
        else//if pre != null head is the same with the original list
            pre.next = last;

        first.next = last.next;
        for(int i = 0; i < n - m; i++)//The following is to reverse the order between [m,n]
        {
            ListNode next = curr.next;
            curr.next = first;
            first = curr;
            curr = next;
        }
        return head;
    }

}
