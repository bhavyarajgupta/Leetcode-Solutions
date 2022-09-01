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
    
    // int count = 0;
    
    public int treerec(TreeNode root,int max){
        if(root == null) return 0;
        
//         if(root.val >= max){
//             count++;
//             max = root.val;
//         }
        
        int count = 0;
        if(root.val >= max){
            count = 1;
            max  = root.val;
        }
        
        
        return count + treerec(root.left,max)+treerec(root.right,max);
        
    }
    
    public int goodNodes(TreeNode root) {
        
      return  treerec(root,root.val);
        
    
        
    }
}