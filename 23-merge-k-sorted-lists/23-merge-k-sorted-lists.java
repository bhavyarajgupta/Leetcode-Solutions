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
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode merge = null;
        
        for(int i=0;i<lists.length;i++){
            merge = merge2LL(lists[i],merge);
        }
        
        return merge;
    }
}