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
    
    int count = 0;
    
    public void treerec(TreeNode root,int max){
        if(root == null) return;
        
        if(root.val >= max){
            count++;
            max = root.val;
        }
        
        treerec(root.left,max);
        treerec(root.right,max);
        
    }
    
    public int goodNodes(TreeNode root) {
        
        treerec(root,root.val);
        
        return count;
        
    }
}