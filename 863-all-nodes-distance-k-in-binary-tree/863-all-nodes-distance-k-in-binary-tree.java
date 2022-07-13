/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    ArrayList<TreeNode> NodetorootPath(TreeNode root,int data){
        if(root == null) return new ArrayList<>();
        
        if(root.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> lside = NodetorootPath(root.left,data);
        if(lside.size()>0){
            lside.add(root);
            return lside;
        }
        
        ArrayList<TreeNode> rside = NodetorootPath(root.right,data);
        if(rside.size()>0){
            rside.add(root);
            return rside;
        }
        
        return new ArrayList<>();
        
    }
    
    void kLeveldown(TreeNode root,int k,TreeNode Blocker,List<Integer> ans){
        if(root == null || k<0 || root == Blocker) return ;
        
        if(k==0){
            ans.add(root.val);
        }
        
        kLeveldown(root.left,k-1,Blocker,ans);
        kLeveldown(root.right,k-1,Blocker,ans);

    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> n2path = NodetorootPath(root,target.val);
        
        int distance = k;
        
        for(int i=0;i<n2path.size();i++){
            if(distance < 0) break;
            TreeNode blocker = (i==0)?null:n2path.get(i-1);
            kLeveldown(n2path.get(i),distance,blocker,ans);
            distance--;
        }
        
        return ans;
    }
}