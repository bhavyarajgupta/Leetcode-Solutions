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
    
    class Pair{
        
        int node = 0;
        int level = 0;
        
        public void Pair(int node,int level){
            this.node = node;
            this.level = level;
        }
        
    }
    
    public void dfs(TreeNode root, int x, int y,int height,int parent ,Pair p1,Pair p2) {
        
        if(root == null) return;
        
        if(root.val == x){
            p1.node = parent; 
            p1.level = height; 
            return;
        }
        
        if(root.val == y){
            p2.node = parent; 
            p2.level = height; 
            return;
        }
        
        dfs(root.left,x,y,height+1,root.val,p1,p2);
        dfs(root.right,x,y,height+1,root.val,p1,p2);
        
        
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Pair p1 = new Pair();
        Pair p2 = new Pair();
        
        dfs(root,x,y,0,0,p1,p2);
        
        return (p1.node != p2.node && p1.level == p2.level) ;
        
    }
}