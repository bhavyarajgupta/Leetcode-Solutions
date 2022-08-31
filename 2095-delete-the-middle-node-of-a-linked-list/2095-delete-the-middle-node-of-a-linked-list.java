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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null ;
        ListNode slow = head;
        ListNode fast = head;
        // ListNode dummy = new ListNode();
        // ListNode tail = dummy;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            // tail.next = slow;
            // tail = tail.next;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next =null;
        
        // tail.next = slow.next;
        // return dummy.next;
        return head;
    }
}