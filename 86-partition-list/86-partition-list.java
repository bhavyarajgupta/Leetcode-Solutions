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
    public ListNode partition(ListNode head, int x) {
         ListNode curr=head;
    ListNode small=new ListNode();
    ListNode gret=new ListNode();
    ListNode s=small;
    ListNode g=gret;
    while(curr!=null)
    {
        if(curr.val<x)
        {
            small.next=curr;
            //System.out.println("small->"+small.next.val);
            small=small.next;
        }
        
        else if(curr.val>=x)
        {
            gret.next=curr;
            //System.out.println("gret->"+gret.next.val);
            gret=gret.next;
        }
        
        curr=curr.next;
    }
    
    gret.next=null;
    small.next=g.next;
    curr=s.next;
    
    
    return s.next;

    }
}