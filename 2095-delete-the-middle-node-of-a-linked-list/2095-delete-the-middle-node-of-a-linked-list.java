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
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(fast != null && fast.next != null){
            tail.next = slow;
            tail = tail.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        // prev.next = slow;
        
        tail.next = slow.next;
        return dummy.next;
    }
}