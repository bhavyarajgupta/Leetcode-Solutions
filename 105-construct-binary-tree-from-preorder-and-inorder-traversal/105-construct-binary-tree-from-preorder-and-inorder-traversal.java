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
    public TreeNode buildTreeNodes(int[] preorder,int prestart,int preend, int[] inorder ,int instart,int inend,
                                  HashMap<Integer,Integer> inMap) {
    
        if(prestart>preend || instart>inend) return null;
        
        TreeNode root = new TreeNode(preorder[prestart]);
        
        int inRoot = inMap.get(root.val);
        int numsleft = inRoot - instart;
        
        root.left = buildTreeNodes(preorder,prestart+1,prestart+numsleft,inorder,instart,inRoot-1,inMap);
        root.right = buildTreeNodes(preorder,prestart+numsleft+1,preend,inorder,inRoot+1,inend,inMap);
        
        return root;

    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        
        TreeNode root = buildTreeNodes(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        
        return root;
    }
}