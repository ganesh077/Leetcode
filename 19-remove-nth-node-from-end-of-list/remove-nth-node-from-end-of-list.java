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
    int count = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head != null) {
            head.next = removeNthFromEnd(head.next,n);
            count++;
            if(count == n) {
                head = head.next;
            }
        }

        return head;
    }
}