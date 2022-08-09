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
        Node delimeter = new Node(-1);
        
        q.add(root);
        q.add(delimeter);
        
        int size = 0;
        
        while(q.size()>0){
            
            Node curr = q.remove();

            if(curr.val == -1){
                size++;
                
                if(q.size() > 0){
                    q.add(delimeter);
                }
            }else{
                
                for(Node child: curr.children){
                    q.add(child);
                }
            }
        }
        
        return size;
        
//          q.add(root);
        
//         int max =0;
//         while(q.size()>0){
//             int counter = q.size();
//         for(int i=0;i<counter;i++){
//           Node curr = q.remove();
    
//           for(Node child:curr.children){
//             q.add(child);
//           }
            
            
//         }
//             max = max+1;
            
//         }
        
        
        // return max;
    }
}