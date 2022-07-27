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
    
    ArrayList<Integer> store ;
    public void inOrder(TreeNode root){
        if(root == null) return ;
        
        inOrder(root.left);
        store.add(root.val);
        inOrder(root.right);
        
    }
    
    public boolean findTarget(TreeNode root, int k) {
        store = new ArrayList<>();
        
        inOrder(root);
        
        int left = 0;
        int right = store.size()-1;
        
        System.out.println(store);
        
        while(left<right){
            int sum = store.get(left)+store.get(right);
            if(sum == k){
                left++;
                right--;
                return true;                
            }else if(sum < k){
                left++;
            }else{
                right--;
            }
            
        }
        
        return false;
    }
}