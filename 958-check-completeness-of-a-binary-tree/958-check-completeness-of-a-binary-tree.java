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
    
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean flag = false;
        
        while(!q.isEmpty()){              
            
            TreeNode par = q.poll();
            
            if(par == null) flag = true;
            else{
                if(flag) return false;
                
                q.offer(par.left);                             
                q.offer(par.right);
                
            }          
        }
        
        return true;
        
        
    }
}