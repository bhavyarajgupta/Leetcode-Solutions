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
    int count = 0;
    
    public void r2npath(TreeNode root , HashSet<Integer> map){
        if(root == null) return;
        
        // map.put(root.val,map.getOrDefault(root.val,0)+1);
        if(map.contains(root.val) == false){
            map.add(root.val);
        }else{
            map.remove(root.val);
        }
        
        if(root.left == null && root.right == null){
            if(map.size() <= 1) count++;
            return;
        }
        
        r2npath(root.left,new HashSet<>(map));
        
        r2npath(root.right,new HashSet<>(map));
        
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        r2npath(root,new HashSet<>());
        
        
        return count;
    }
}
