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
    
    int Max(TreeNode node){
        if(node.right != null){
            return Max(node.right);
        }
        
        return node.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                int inOrderleftpre = Max(root.left);
                root.val = inOrderleftpre;
                root.left = deleteNode(root.left,inOrderleftpre);
            }
            
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        
        return root;
        
    }
}