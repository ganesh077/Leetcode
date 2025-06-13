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
            if(n > 0) {
                return null;
            }
            return head;
        }
        ListNode p1 = head,p2 = head;
        int len = 0;
        while(p1 != null) {
            len++;
            p1 = p1.next;
        }

        int required = (len-n)-1;

        if(required < 0) {
            head = head.next;
            return head;
        }

        System.out.print(required);
        while(required > 0 && p2 != null)  { 
            p2 = p2.next;
            required--;
        }

        
        p2.next = p2.next.next;
        //System.out.print(p2.val);

        return head;
    }
}