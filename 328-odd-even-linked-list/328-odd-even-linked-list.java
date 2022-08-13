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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode oddDummy = new ListNode();
        ListNode evenDummy = new ListNode();
        ListNode tailodd = oddDummy;
        ListNode taileven = evenDummy;
        
        int index = 1;
        while(head != null){
            if(index % 2 != 0){
                tailodd.next = head;
                tailodd = tailodd.next;
            }else{
                taileven.next = head;
                taileven = taileven.next;
            }
            
            head = head.next;
            index++;
        }
        
        tailodd.next = evenDummy.next;
        taileven.next = null;
        
        
        return oddDummy.next;
    }
}