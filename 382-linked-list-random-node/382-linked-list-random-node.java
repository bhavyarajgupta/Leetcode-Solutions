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

    
    ArrayList<Integer> store;
    public Solution(ListNode head) {
        
        store = new ArrayList<>();
        
        while(head != null){
            store.add(head.val);
            head = head.next;
        }
        
    }
    
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    public int getRandom() {
        
        int rndom = getRandomNumberUsingNextInt(0,store.size());

        return store.get(rndom);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */