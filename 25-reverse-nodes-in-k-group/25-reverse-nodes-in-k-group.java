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
    
    ListNode reverse(ListNode head){
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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr;
            ListNode prev = temp;
            int count =0;
            
            while(prev !=null && count<k){
                
                count++;
                if(count < k) 
                    prev = prev.next;
                    
            }
            if(count<k){
                tail.next = curr;
                return dummy.next;
            }
            
            curr = prev.next;
            
            prev.next = null;
            ListNode reversed = reverse(temp);
            tail.next = reversed;
            tail = temp;
            
        }
        
        
        return dummy.next;
        
    }
}