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
        
        Node head = root;
        
        while(head != null){
            Node dummy = new Node(-1);
            Node tail = dummy;
            
            while(head != null){
                   
                if(head.left != null){
                    tail.next = head.left;
                    tail = tail.next;
                }
                
                if(head.right != null){
                    tail.next = head.right;
                    tail = tail.next;
                }
                
                head = head.next;
            }
            
            head = dummy.next;
           
        }
        
        return root;
    }
}