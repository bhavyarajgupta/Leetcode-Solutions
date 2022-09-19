/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
//     public ListNode reverse(ListNode node){
//         if(node == null || node.next == null) return node;
        
//         ListNode temp = reverse(node.next);
        
//         node.next.next = node;
//         node.next = null;
        
//         return temp;
//     }
    
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode temp = head;
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(temp !=null && temp.next !=null){
            ListNode r = temp;
            ListNode r2 = r.next;
            temp = temp.next.next;
            r.next.next = r ; 
            r.next = null;
            
            tail.next = r2;
            tail = r;
        }
        tail.next = temp;
        
        return dummy.next;

    }
}