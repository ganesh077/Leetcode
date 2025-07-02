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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Map<TreeNode,TreeNode> map = new HashMap<>();
        buildmap(root,null,map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int current = 0;

        while(!q.isEmpty()) {
            if(current == k) {
                for(TreeNode t:q) {
                    res.add(t.val);
                }

                return res;
            }
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur  = q.remove();
                if(cur.left != null && visited.add(cur.left)) q.add(cur.left);
                if(cur.right != null && visited.add(cur.right)) q.add(cur.right);

                TreeNode parent = map.get(cur);
                if(parent != null && visited.add(parent)) q.add(parent);
            }

            current++;
        }

        return res;
    }

    public void buildmap(TreeNode child, TreeNode parent, Map<TreeNode,TreeNode> map) {
        if(child == null) return;
        map.put(child,parent);
        buildmap(child.left,child,map);
        buildmap(child.right,child,map);
    }
}