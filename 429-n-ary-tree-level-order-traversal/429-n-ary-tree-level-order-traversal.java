/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        
        
        q.add(root);
        while(q.size()>0){
            int counter = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<counter;i++){
                Node par = q.remove();
                temp.add(par.val);
                // if(par.children)
                for(Node child:par.children){
                    q.add(child);
                }
                    
            }
            
            res.add(temp);
        }
        
        return res;
    }
}