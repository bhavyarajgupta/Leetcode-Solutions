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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
//         while(head != null && head.next != null){
//             if(head.val == 0){
//                 ListNode prev = head.next;
//                 int sum = 0;
//                 while(prev != null && prev.val != 0){
//                     sum += prev.val;
//                     prev = prev.next;
//                 }
                
//                 tail.next = new ListNode(sum);
//                 tail = tail.next;
//                 head = prev;
//             }
//             else{
//                     head = head.next;
//             }
//         }
        
        int toggle = 0;
        int sum = 0;
        while(head != null){
            if(head.val == 0){
                toggle++;
            }
            
            if(toggle == 1){
                sum+=head.val;
                // Systee.out.println(sum);
            }
            
            if(toggle == 2){
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
                toggle--;
            }
            
            
            head = head.next;
        }
        
        tail.next = null;
        
        return dummy.next;
    }
}