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
        
        while(root != null){
            if(root.left == null){
                ans.add(root.val);
                root = root.right;
            }else{
                TreeNode iop = root.left;
                
                while(iop.right !=null && iop.right != root)
                    iop = iop.right;
                
                if(iop.right == null){
                    iop.right = root;
                    root = root.left;
                }else{
                    iop.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}