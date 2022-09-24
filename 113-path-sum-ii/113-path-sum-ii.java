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
    
    List<List<Integer>> ans  = new ArrayList<>();
    public void DFS(List<Integer> temp,TreeNode root,int target,int total){
        if(root == null){
            return ;
        }
        
        if(root.left == null && root.right == null){
            if(total+root.val == target){
                List<Integer> aa = new ArrayList<>();
                aa.addAll(temp);
                aa.add(root.val);
                ans.add(aa);
                return ;
            }
        }
        
        
        temp.add(root.val);
        // total += root.val;
        
        DFS(temp,root.left,target,total+root.val);
        DFS(temp,root.right,target,total+root.val);
        
        
        temp.remove(temp.size()-1);
        

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        
        DFS(new ArrayList<>(),root,targetSum,0);
        return ans;
        
        
    }
}