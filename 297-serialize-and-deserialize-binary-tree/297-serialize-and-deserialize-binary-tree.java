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
    public  class Pair {
        TreeNode node;
        int state;
    
        Pair(TreeNode node, int state) {
          this.node = node;
          this.state = state;
        }
    }

    // Encodes a tree to a single string.
    
    void builder(TreeNode root,StringBuilder sb){
        if(root ==null ){
            sb.append("N,");
            return;
        }
        
        sb.append(root.val+",");
        builder(root.left,sb);
        builder(root.right,sb);
    }
    
    public String serialize(TreeNode root) {
        if(root == null) return "";
	    StringBuilder sb = new StringBuilder("");
	    
        builder(root,sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    int idx =0;
    TreeNode solver(String [] s){
        if(idx >= s.length || s[idx].equals("N")){
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(s[idx++]));
        node.left = solver(s);
        node.right = solver(s);
        
        return node;
    }
    public TreeNode deserialize(String data) {
        
        if(data.length() == 0 || data == "") return null;
        
        String[] s = data.split(",");

        return solver(s);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));