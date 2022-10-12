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
    
//     private void dfs(TreeNode root,TreeNode par,HashSet<TreeNode> covered){
        
//         if(root == null) return;
        
//         dfs(root.left,root,covered);
//         dfs(root.right,root,covered);
        
//         if(par == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right) ){
//             cam++;
//             covered.add(par);
//             covered.add(root.left);
//             covered.add(root.right);
//             covered.add(root);
//         }
        
//     }
    
    private int dfs(TreeNode root){
        if(root == null) return 1;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(left == 0 || right == 0){
            cam++;
            return 2; //camera laga diya
        }
        else if(left == 2 || right == 2){
            // vha par pass ma camera laga hua ha 
            return 1;
        }
        
        return 0;
        
        
    }

    public int minCameraCover(TreeNode root) {
        
//         HashSet<TreeNode> covered = new HashSet<>();
        
//         covered.add(null);
        
        int ans = dfs(root);
        
        return ans == 0?cam+1:cam;
        
    }
}