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
        ListNode fast= head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = ahead;
        }
        
        return prev;
        
    }
        
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = mid(head);
        
        ListNode aftermid = mid.next;
        mid.next = null;
        
        ListNode reversedaftermid = reverse(aftermid);
        
        while(head != null && reversedaftermid != null){
            if(head.val != reversedaftermid.val)
                return false;
            
            head = head.next;
            reversedaftermid = reversedaftermid.next;
        }
        
        return true;        
    }
}