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
    public TreeNode reverseOddLevels(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        
        stk.push(root);
        
        // q.add(root);
        int level = 0;
        while(!stk.isEmpty()){
            
            ArrayList<TreeNode> reverse = new ArrayList<>();
            int size = stk.size();
            Stack<TreeNode> temp = new Stack<>();
            
            for(int i=0;i<size;i++){
            
            TreeNode par = stk.pop();
            
            
            if(level % 2 == 0){
                
                if(par.right != null){
                    temp.push(par.right);
                    reverse.add(par.right);
                }
                if(par.left != null){
                    temp.push(par.left);
                    reverse.add(par.left);
                }
                
                
            }else{
                
                if(par.left != null){
                    temp.push(par.left);
                }
                
                if(par.right != null){
                    temp.push(par.right);
                }
                }
            }
            
            if(reverse.size() > 0){
                for(int i=0,j=reverse.size()-1;i < j ;i++,j--){
                    int temp1= reverse.get(i).val;
                    // reverse.set(i,reverse.get(j));
                    // reverse.set(j,temp); 
                    
                    reverse.get(i).val = reverse.get(j).val;
                    reverse.get(j).val = temp1;
                    
                }
            }
            
            
            
            level++;
            stk = temp;
            
            
        }
        
        return root;
        
    }
}