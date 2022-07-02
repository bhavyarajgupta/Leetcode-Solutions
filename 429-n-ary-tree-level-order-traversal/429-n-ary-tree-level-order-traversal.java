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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res; 
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
       
        
        
        while(q.size()>0){
            List <Integer> store = new ArrayList<>();
            int count =q.size();
            for(int i=0;i<count;i++){
            Node curr = q.remove();
            store.add(curr.val);
                
            for(Node child:curr.children)
                
                q.add(child);
                
            }
            
            res.add(store);
        }
        
        return res;
    }
}