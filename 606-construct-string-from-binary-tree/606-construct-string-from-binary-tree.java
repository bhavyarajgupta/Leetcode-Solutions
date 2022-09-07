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
    
    StringBuilder ans = new StringBuilder("");
    
    public void preOrd(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.append(root.val);
            return;
        }
        
        ans.append(root.val);
        if(root.left == null) ans.append("()");
        else{
            ans.append("(");
            preOrd(root.left);
            ans.append(")");
        }
        
        if(root.right !=null){
            ans.append("(");
            preOrd(root.right);
            ans.append(")");
        }       
        
    }
    
    public String tree2str(TreeNode root) {
        
        preOrd(root);
        
        return ans.toString();
    }
}