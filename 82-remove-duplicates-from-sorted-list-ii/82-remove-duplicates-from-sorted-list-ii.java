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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                ListNode curr = head;
                while(curr != null && head.val == curr.val){
                    curr = curr.next;
                }
        
                head = curr;
            }else{
                tail.next = head;
                tail = tail.next;
                head = head.next;
            }
        }
        
        tail.next = null;
        
        return dummy.next;
        
    }
}