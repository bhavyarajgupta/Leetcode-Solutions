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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        int [] ans = new int[2];
        Arrays.fill(ans,-1);
        if(head == null || head.next == null) return ans;
        
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode prev = head;
        head = head.next;
        int el = 1;
        while(head != null && head.next != null){
            el++;
            // System.out.println(prev.val + " , "+head.val + " , "+head.next.val);
            if((prev.val > head.val && head.next.val > head.val) || (prev.val < head.val && head.next.val < head.val) ){
                list.add(el);
                // System.out.println(el);
            }
            
            prev = head;
            head = head.next;
        }
        
        
        
        if(list.size()>=2)
        {
            Collections.sort(list);
            
            ans[0] = Integer.MAX_VALUE;
            for(int i=0;i<list.size()-1;i++){
                ans[0] = Math.min(Math.abs(list.get(i+1) - list.get(i)),ans[0]);
            }
            ans[1] = list.get(list.size()-1) - list.get(0);
        }
        
        return ans;
    }
}