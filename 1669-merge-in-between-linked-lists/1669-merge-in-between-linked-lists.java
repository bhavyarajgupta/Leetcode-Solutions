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
        
        ListNode prev = temp.next;
        while(prev != null && count < b){
            prev = prev.next;
            count++;
        }
        
        // ListNode temp2 = list2;
        temp.next = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next = prev.next;
        // temp.next = list2;
        
        return list1;
    }
}