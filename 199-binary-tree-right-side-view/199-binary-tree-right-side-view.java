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
    
    public  List<Integer> BFS(TreeNode root){
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
    
    
    
    
    public void DFS(List<Integer> ans , TreeNode root,int depth){
        
        if(root == null) return;
        
        if(ans.size() == depth) ans.add(root.val);
        
        DFS(ans,root.right,depth+1);
        DFS(ans,root.left,depth+1);

        
        
    }
    

    public List<Integer> rightSideView(TreeNode root) {
       // return BFS(root);
        List <Integer> ans = new ArrayList<>();
        DFS(ans,root,0);
        
        return ans;
        
    }
}