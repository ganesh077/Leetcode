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
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            stack2.add(node);

            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }

        while(!stack2.isEmpty()) res.add(stack2.pop().val);
        return res;
    }
}