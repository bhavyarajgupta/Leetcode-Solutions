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
    
//     public void rightside(TreeNode root,List<Integer> ans){
//         if(root == null) return;
        
//         if(root.right != null)
//             ans.add(root.right.val);
        
//         rightside(root.right,ans);
//     }
    
//      public void leftside(TreeNode root,List<Integer> ans){
//         if(root == null) return;
        
//         if(root.left != null)
//             ans.add(root.left.val);
        
//         leftside(root.left,ans);
//     }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        
        
        if(root == null) return ans;
        
        ArrayDeque<TreeNode > q = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size() > 0){
            
            ans.add(q.peekLast().val); 
            
            int size = q.size();
            
            while(size-->0){
                TreeNode curr = q.remove();
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        
        return ans;
    }
}