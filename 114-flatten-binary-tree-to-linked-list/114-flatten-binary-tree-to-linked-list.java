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
    // Private LinkedList res = new LinkedList<>();
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
            TreeNode temp = root.left;
            //traverse the left subtree linkedlist to right till right is null
            while(temp.right!=null){
                temp=temp.right;
            }
            //placing the right subtree linked-list head at the end of left subtree linked list
            temp.right=root.right;
            //placing the left-subtree linked to the right of root.
            root.right=root.left;
            //finally marking the left of the root to null
            root.left=null;
        }
    }
}