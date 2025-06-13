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
    public boolean isPalindrome(ListNode head) {
        //ListNode reversed = reverse(head);
        if(head == null || head.next == null) {
            return true;
        }
        ListNode fast=head, slow=head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next; 
            
        }
        
        ListNode reversed = reverse(slow);
        ListNode p1 = head, p2 = reversed;
        while(p2 != null) {
            if(p1.val != p2.val) {
                return false;
            }
            //System.out.println(mid.val + "mid");
            p1 = p1.next;
            //System.out.println(reversed.val + "reversed");
            p2 = p2.next;
        }

        slow.next = reverse(reversed);
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;

        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}