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

    ListNode head = null;
    Random rand = null;
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    public int getRandom() {
        int res =-1;
        ListNode t =head;
        
        for(int i=1;t != null;i++){
            if(rand.nextInt(i) == i-1){
                res = t.val;
            }
            
            t = t.next;
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */