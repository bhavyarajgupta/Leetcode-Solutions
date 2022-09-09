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
    
    int k = 0;
    int ans = 0;
    
    public void kth(TreeNode root){
        if(root == null) return ;
        
        kth(root.left);
        // if(left != -1) return left;
        k--;
        if(k==0){
            ans = root.val;
            return; 
        }
        kth(root.right);
        // if(right != -1) return right;
        
    }
    
    public int kthSmallest(TreeNode root, int s) {
        
       k=s;
       kth(root);
       return ans; 
    
        
    }
}