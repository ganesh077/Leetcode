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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        ListNode first = head;
        ListNode second = head;
        ListNode prev = head;

        if(head == null || head.next == null) {
            return null;
        }
        
        while(second != null && second.next != null) {
            second = second.next.next;
            prev = first;
            first = first.next;
        }

        System.out.println(first.val);
        prev.next = prev.next.next;
        return temp;
    }
}