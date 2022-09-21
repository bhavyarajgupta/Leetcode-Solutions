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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
          
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- >0){
                TreeNode par = q.remove();
                temp.add(par.val);
                
                if(par.left!=null) q.add(par.left);
                if(par.right!=null) q.add(par.right);
                
            }
            
            ans.add(temp);
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}