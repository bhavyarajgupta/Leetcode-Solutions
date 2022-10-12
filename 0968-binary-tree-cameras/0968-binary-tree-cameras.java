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
    int cam = 0;
    
    private void dfs(TreeNode root,TreeNode par,HashSet<TreeNode> covered){
        
        if(root == null) return;
        
        dfs(root.left,root,covered);
        dfs(root.right,root,covered);
        
        if(par == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right) ){
            cam++;
            covered.add(par);
            covered.add(root.left);
            covered.add(root.right);
            covered.add(root);
        }
        
    }
    
    public int minCameraCover(TreeNode root) {
        
        HashSet<TreeNode> covered = new HashSet<>();
        
        covered.add(null);
        
        dfs(root,null,covered);
        
        return cam;
        
    }
}