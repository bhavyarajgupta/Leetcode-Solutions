/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null || root.left == null || root.right == null){
            return root;
        }
        
//         root.left.next = root.right; // connection
//         while(root.next != null)
//             root.right.next = root.next.left;       
        
//         connect(root.left);
//         connect(root.right);
        
//         return root;
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        
        Node temp = new Node(-1);
        temp.right = null;
        
        while(!q.isEmpty()){
            int size = q.size();
            Node ans = new Node(-1);
            Node tail = ans;
            
            for(int i =0;i<size;i++){
                Node par = q.remove();
                
                tail.next = par;
                tail = tail.next;
               
                if(par.left != null){
                    q.add(par.left);
                }
                
                if(par.right != null){
                    q.add(par.right);
                }
                
            }
           
            
           
        }
        
        return root;
        
        
        
    }
}