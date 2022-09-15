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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        
        int count = 1;
        while(temp !=null &&  count < a){
            temp = temp.next;
            count++;
        }
        
        ListNode prev = temp;
        while(prev != null && count <= b+1){
            prev = prev.next;
            count++;
        }
        
        ListNode temp2 = list2;
        while(temp2.next != null){
            temp2 = temp2.next;
        }
        
        temp2.next = prev;
        temp.next = list2;
        
        return list1;
    }
}