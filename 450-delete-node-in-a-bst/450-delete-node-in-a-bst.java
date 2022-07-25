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
    public int max(TreeNode node){
       if(node.right != null){
            return max(node.right);
        }
        return node.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        
        if(root.val == key){
            if(root.left == null && root.right == null){
               //no leaf node
                return null;
            }else if(root.left == null){
                // no right child
                
                return root.right;
            }else if(root.right == null){
                //no left child
                
                return root.left;
            }else{
                
                //both child exist 
                int inorderleftpredessor = max(root.left);
                System.out.println(inorderleftpredessor);
                root.val = inorderleftpredessor;
                root.left = deleteNode(root.left,inorderleftpredessor);
                
            }
        }else if(root.val < key){
             root.right = deleteNode(root.right,key);
        }else{
             root.left = deleteNode(root.left,key);
        }
        
        return root;
    }
}