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
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curr; 
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.curr = root;
        pushleft(curr);
    }
    
    public void pushleft(TreeNode root) {
        
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
        }
    
    public int next() {
        curr = stack.pop();
        if(curr.right != null) {
            pushleft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */