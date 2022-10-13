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
    // int cam = 0;
    
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
    
    class Pair{
        int status;
        int camera;
        public Pair(int s,int c){
            status = s;
            camera = c;
        }
        
    }
    
    private Pair dfs(TreeNode root){
        if(root == null) return new Pair(1,0) ;
        
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        int total = left.camera+right.camera;
        
        if(left.status == 0 || right.status == 0){
            total++;
            return new Pair(2,total); //camera laga diya
        }
        else if(left.status == 2 || right.status == 2){
            // vha par pass ma camera laga hua ha 
            return new Pair(1,total);
        }
        
        return new Pair(0,total);
        
        
    }

    public int minCameraCover(TreeNode root) {
        
//         HashSet<TreeNode> covered = new HashSet<>();
        
//         covered.add(null);
        
        Pair ans = dfs(root);
        
        return ans.status == 0?ans.camera+1:ans.camera;
        
    }
}