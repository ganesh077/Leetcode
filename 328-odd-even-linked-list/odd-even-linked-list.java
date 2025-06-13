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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode oddp = head;
        ListNode evenHead = head.next;
        ListNode evenp = evenHead;

        while(evenp!=null && evenp.next!=null) {
            oddp.next = evenp.next;
            oddp = oddp.next;

            evenp.next = oddp.next;
            evenp = evenp.next;
        }

        oddp.next = evenHead;
        return head;
}
}