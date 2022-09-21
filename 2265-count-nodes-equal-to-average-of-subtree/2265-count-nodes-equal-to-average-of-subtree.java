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
    
    private int count = 0;
    
    private int[] recpost(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        
        
        int[] left = recpost(root.left);
        int[] right = recpost(root.right);
    
        int total = left[0]+right[0]+root.val;
        int totalnode = left[1]+right[1]+1;
        if(root.val == (total/totalnode)){
            count++;
        }
        
        return new int[]{total,totalnode};
    }
    
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return count;       
        
        recpost(root);
        
        return count;
    }
}