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
    
    public void r2npath(TreeNode root , HashMap<Integer,Integer> map){
        if(root == null) return;
        
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        
        if(root.left == null && root.right == null){
            boolean flag = true;
            int odd = 0;
            for(int i=1; i<=9;i++){
                if((map.getOrDefault(i,0) & 1) == 1){
                    odd++;
                    if(odd > 1 ){
                        flag = false;
                        break;
                    }
                    
                }
            }
            
            if(flag == true){
                count++;
            }
            
            map.put(root.val,map.get(root.val)-1);
            
            return;
        }
        
        r2npath(root.left,map);
        r2npath(root.right,map);
        map.put(root.val,map.get(root.val)-1);
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        
        r2npath(root,new HashMap<>());
        
        return count;
    }
}
