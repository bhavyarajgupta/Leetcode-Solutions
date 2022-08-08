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
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
   
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode temp = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return temp;
    }

    public boolean isPalindrome(ListNode head) {
        
//         ArrayList<Integer> list = new ArrayList<>();
        
//         while(head != null){
//             list.add(head.val);
//             head = head.next;
//         }
        
        
//         int i =0;
//         int j= list.size()-1;
        
//         while(i<j){
//             if(list.get(i) != list.get(j)){
//                 return false;
//             }
//             i++;
//             j--;
//         }
        
        // return true;
        
        ListNode mid = mid(head);
        
        ListNode reverse = reverse(mid.next);
        mid.next = null;
               
        while(head != null && reverse != null){
            if(head.val != reverse.val) return false;
            
            head = head.next;
            reverse = reverse.next;
        }
        return true;       
        
    }
}