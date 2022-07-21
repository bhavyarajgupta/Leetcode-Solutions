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
    public ListNode reverseList(ListNode head) {
        
        if(head == null){
            return head;
        }
        ListNode prev =null;
        ListNode curr = head;
               
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
     
        return prev;
        
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1 ;
        ListNode curr = head;
        ListNode pstart = null;
        while(i<left){
            pstart = curr;
            curr = curr.next;
            i++;
        }
          
        
        ListNode prev =null;
        ListNode ahead = null;
        ListNode reverseHead = curr;
               
        while(curr != null && i<= right){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
            i++;
        }
        
        if(pstart != null){
            pstart.next = prev;
        }
        
        reverseHead.next = ahead;
        
        return left == 1?prev:head;
    }
}