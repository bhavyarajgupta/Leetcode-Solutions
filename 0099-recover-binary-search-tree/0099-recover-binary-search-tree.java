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
    
    void inorder(ArrayList<TreeNode> arr , TreeNode root){
        
        if(root == null) return;
        
        inorder(arr,root.left);
        arr.add(root);
        inorder(arr,root.right);
        
    } 
    
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        
        inorder(ans,root);
        
        TreeNode var1 = null,var2 = null;
        
        for(int i=0;i<ans.size()-1;i++){
            if(var1 == null && ans.get(i).val > ans.get(i+1).val ){
                var1 = ans.get(i);
            }
            
            if(var1 != null && ans.get(i).val > ans.get(i+1).val){
                var2 = ans.get(i+1);
            }
        }
        
        int temp = var1.val;
        var1.val = var2.val;
        var2.val = temp;
        
        
        
        
    }
}