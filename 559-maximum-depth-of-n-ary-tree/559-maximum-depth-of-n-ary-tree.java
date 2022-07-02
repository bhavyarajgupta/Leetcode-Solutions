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
    public int maxDepth(Node root) {
        if(root == null) return 0;
        
        Queue<Node> q = new ArrayDeque<>();
        
         q.add(root);
        
        int max =0;
        while(q.size()>0){
            int counter = q.size();
        for(int i=0;i<counter;i++){
          Node curr = q.remove();
    
          for(Node child:curr.children){
            q.add(child);
          }
            
            
        }
            max = max+1;
            
        }
        return max;
    }
}