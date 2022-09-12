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
    public void recoverTree(TreeNode root) {
        //mrorris inorder traversal
        
        if(root == null) return;
        
        TreeNode prev = null;
        
        TreeNode first = null;
        TreeNode second = null;
        
        
        while(root != null){
            
            if(root.left == null){
                //print root
                if(prev != null && prev.val > root.val){
                    if(first == null){
                        first =  prev;
                        
                    }
                    
                    second = root;
                    
                }
                
                prev = root;
                
                root = root.right;
                
            }else{
                
                TreeNode cur = root.left;
                
                while(cur.right != null && cur.right != root) cur = cur.right;
                
                if(cur.right == null){
                    cur.right = root;
                    root = root.left;
                }else{
                    cur.right = null;
                    //print root
                    if(prev != null && prev.val > root.val){
                        if(first == null){
                            first =  prev;
                        
                        }
                    
                        second = root;
                    }
                     prev = root;
                    
                    root = root.right;
                }
                
            }
        }
        
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}