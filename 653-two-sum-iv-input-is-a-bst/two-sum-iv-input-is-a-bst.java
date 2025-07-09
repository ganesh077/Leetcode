/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> mylist = new ArrayList<>();
        helper(root,k,mylist);
        int l=0, r=mylist.size()-1;

        while(l < r) {
            if(mylist.get(r)+mylist.get(l) == k) {
                return true;
            }
            else if(mylist.get(r)+mylist.get(l) < k) {
                l++;
            }
            else {
                r--;
            }
        }

        return false;
    }

    public void helper(TreeNode root, int k ,List<Integer> mylist) {
        if(root == null) return;

        helper(root.left,k,mylist);
        mylist.add(root.val);
        helper(root.right,k,mylist);
    }

    
}