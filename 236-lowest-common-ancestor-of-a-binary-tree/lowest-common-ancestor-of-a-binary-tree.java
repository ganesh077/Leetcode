/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        helper(root,p,left);
        helper(root,q,right);
        
        int i=0;

        while(i < left.size() && i < right.size() && left.get(i) == right.get(i)) {
            i++;
        }

        return left.get(i-1);
    }

    public boolean helper(TreeNode root,TreeNode find,List<TreeNode> st) {
        if(root == null) return false;
        st.add(root);
        if(root == find) return true;
        if(helper(root.left,find,st) || helper(root.right,find,st)) {
            return true;
        }

        st.remove(st.size()-1);
        return false;

        
    }

     
}