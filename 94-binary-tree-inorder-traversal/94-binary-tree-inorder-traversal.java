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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        inord(root,ans);
        return ans;
    }
    
    public void inord(TreeNode root,List<Integer> ans){
        if(root == null) return ;
        
        inord(root.left,ans);
        ans.add(root.val);
        inord(root.right,ans);
        
    }
}