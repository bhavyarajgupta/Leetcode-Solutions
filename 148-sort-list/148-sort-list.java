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
        ListNode slow= head;
        ListNode fast = head.next;
        
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode merge2LL(ListNode l1,ListNode l2){
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;

            }
        }
        
        if(l1 != null){
            tail.next = l1;
        }else if(l2 != null){
            tail.next = l2;
        }
        
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = mid(head);
        ListNode midnext = mid.next;
        mid.next = null;
        
        System.out.println(head.val);
        ListNode temp = sortList(head);
        ListNode temp2 = sortList(midnext);
        
        ListNode merged  = merge2LL(temp,temp2);
        
        return merged;
    }
}