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
    
    // List<TreeNode> inord = new ArrayList<>();
    Stack<TreeNode> partialinord = new Stack<>();

    void parinorder(TreeNode root){
        
        while(root != null){
            partialinord.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        parinorder(root);
        
    }
    
    public int next() {
        TreeNode par = partialinord.pop();
        parinorder(par.right);
        return par.val;
    }
    
    public boolean hasNext() {
        return partialinord.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */