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
    
    public ListNode helper(ListNode lists[],int left,int right){
        if(left == right) return lists[left];
        
        int mid = (left+right)/2;
        
        ListNode lefted = helper(lists,left,mid);
        ListNode righted = helper(lists,mid+1,right);
        
        return merge2LL(lefted,righted);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) return null;
        
        return helper(lists , 0 ,lists.length-1);
        
        
    }
    
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         ListNode merge = null;
        
//         for(int i=0;i<lists.length;i++){
//             merge = merge2LL(lists[i],merge);
//         }
        
//         return merge;
//     }
}