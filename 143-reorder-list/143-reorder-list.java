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
    
    public ListNode mid(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow ;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        
        ListNode mided = mid(head);
        ListNode reverse = reverse(mided.next);
        mided.next = null;
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        
        while(head != null || reverse != null){
            // tail.next = head;
            // tail = tail.next;
            // tail.next = reverse;
            // tail = tail.next;
            
            if(head != null){
                tail.next = head;
                tail = tail.next;
                head = head.next;     
            }
            if(reverse != null){
                tail.next = reverse;
                tail = tail.next;
                reverse = reverse.next;     
            }            
            
            // reverse = reverse.next;
            // head = head.next;
            
        }
        
        // tail.next = null;
        
        head = dummy.next;
        
        
    }
}