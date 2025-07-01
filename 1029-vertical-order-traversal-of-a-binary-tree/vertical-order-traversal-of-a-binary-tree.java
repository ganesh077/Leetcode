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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        helper(root,0,0,map);
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            int col = entry.getKey();
            List<int[]> nodes = entry.getValue();

            nodes.sort((a,b) -> {
                if(a[0] == b[0]) return Integer.compare(a[1],b[1]);
                else return Integer.compare(a[0],b[0]);
            });

            List<Integer> ar = new ArrayList<>();
            for(int[] a: nodes) {
                ar.add(a[1]);
            }

            res.add(ar);
        }
        return res;
    }

    public void helper(TreeNode root, int row,int col, TreeMap<Integer,List<int[]>> map) {
        if(root == null) {
            return;
        }

        if(!map.containsKey(col)) {
            map.put(col, new ArrayList<>());
        }
        map.get(col).add(new int[]{row,root.val});

        helper(root.left,row+1,col-1,map);
        helper(root.right,row+1,col+1,map);
    }
}