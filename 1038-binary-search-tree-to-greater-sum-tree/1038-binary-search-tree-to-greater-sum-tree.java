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
    
    static int sum = 0;
    public TreeNode reverseInorder(TreeNode node){
        if(node == null) return null;    
        
        node.right = reverseInorder(node.right);
        sum+=node.val;
        node.val = sum;
        node.left = reverseInorder(node.left);

        return node;
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        return reverseInorder(root);
    }
}