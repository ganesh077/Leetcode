/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        ListNode tmp = head;

        while(tmp != null) {
            if(seen.contains(tmp)) {
                return true;
            }
            seen.add(tmp);
            tmp = tmp.next;
        }

        return false;

    }
}