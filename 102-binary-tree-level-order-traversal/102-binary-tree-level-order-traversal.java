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
    public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
          int counter = q.size();
            List<Integer> temp = new ArrayList<>();
          for(int i=0;i<counter;i++){
            TreeNode par = q.remove();
            temp.add(par.val);
            if(par.left != null){
              q.add(par.left);
            }
            if(par.right != null){
              q.add(par.right);
            }
          }
            ans.add(temp);
          // System.out.println();
        }
  
        return ans;
    }
}