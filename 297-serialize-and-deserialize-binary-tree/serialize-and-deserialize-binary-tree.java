/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(curr != null) {
                    sb.append(Integer.toString(curr.val)+",");
                    q.add(curr.left);
                    q.add(curr.right);
                }
                else {
                    sb.append("null,");
                }
                
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        int pointer = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[pointer++]));
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(!arr[pointer].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(arr[pointer]));
                    pointer++;
                    q.add(curr.left);
                }
                else {
                    pointer++;
                }
                if(!arr[pointer].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(arr[pointer]));
                    pointer++;
                    q.add(curr.right);
                }
                else {
                    pointer++;
                }
                
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));