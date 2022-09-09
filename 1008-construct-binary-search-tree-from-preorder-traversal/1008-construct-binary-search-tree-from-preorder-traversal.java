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
    
    int i =0;
    
    TreeNode bst(int[] pre,int Ubound){
          if(i == pre.length || pre[i]>Ubound) return null;
         
         TreeNode root = new TreeNode(pre[i++]);
         root.left = bst(pre,root.val);
         root.right = bst(pre,Ubound);
         
         return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return bst(preorder,Integer.MAX_VALUE);
        
        
    }
}