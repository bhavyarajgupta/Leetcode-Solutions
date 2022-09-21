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
    
    
    int rec(TreeNode root,int sum){
        if(root == null) return 0;
                
        if(root.left == null &&  root.right == null)
        {
            //sum = sum*10+roo.val; conversion formula
            sum = sum*10+root.val;
            return sum;
        }
        
        sum = sum*10+root.val;
        int left = rec(root.left,sum);
        int right = rec(root.right,sum);
        
        return left+right;
    }
    
    public int sumNumbers(TreeNode root) {
        return rec(root,0);
    }
}