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
class BSTIterator {
    
    List<TreeNode> inord = new ArrayList<>();
    int idx =0;

    void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        inord.add(root);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
        
    }
    
    public int next() {
        return inord.get(idx++).val;
    }
    
    public boolean hasNext() {
        return idx<inord.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */