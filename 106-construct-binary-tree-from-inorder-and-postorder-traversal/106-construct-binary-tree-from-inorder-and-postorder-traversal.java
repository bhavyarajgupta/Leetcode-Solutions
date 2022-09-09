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
    public TreeNode BuildT(int[] postorder,int pstart ,int pend,int[] inorder,int istart,int iend,HashMap<Integer,Integer> inMap){
        if(istart>iend || pstart>pend) return null;
        
        TreeNode root = new TreeNode(postorder[pend]);
        
        int idx = inMap.get(postorder[pend]);
        int num = iend-idx;

        root.left = BuildT(postorder,pstart,pend-num-1,inorder,istart,idx-1,inMap);
        root.right = BuildT(postorder,pend-num,pend-1,inorder,idx+1,iend,inMap);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        
        TreeNode root = BuildT(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
        
        return root;     
        
    }
}