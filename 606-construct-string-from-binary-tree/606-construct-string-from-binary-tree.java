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
    
    String ans="";
    
    public void preOrd(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans+= root.val;
            return;
        }
        
        ans+=root.val+"";
        if(root.left == null) ans+="()";
        else{
            ans+= "(";
            preOrd(root.left);
            ans+=")";
        }
        
        if(root.right !=null){
            ans+= "(";
            preOrd(root.right);
            ans+=")";
        }       
        
    }
    
    public String tree2str(TreeNode root) {
        
        preOrd(root);
        
        return ans;
    }
}