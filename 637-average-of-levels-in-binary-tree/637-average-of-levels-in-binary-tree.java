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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        
        q.add(root);
        
        while(q.size()>0){
            int counter = q.size();
            double sum = 0;
            for(int i=0;i<counter;i++){
                TreeNode par = q.remove();
                sum+=par.val;
                if(par.left != null) q.add(par.left);
                if(par.right != null) q.add(par.right);
            }
            
            res.add(sum/counter);
        }
        return res;
    }
}