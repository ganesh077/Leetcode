/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode p1 = dummy,p2 = dummy;

        while(n >= 0) {
            p2 = p2.next;
            n--;
        }

//System.out.println(p2.val);

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.val);
        p1.next = p1.next.next;
        return dummy.next;
    }
}