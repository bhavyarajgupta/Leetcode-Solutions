/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {

  public:
    ListNode * reverse(ListNode * head) {

      ListNode * prev = nullptr, * curr = head;
      while (curr != nullptr) {

        ListNode * ahead = curr -> next;

        curr -> next = prev;

        prev = curr;

        curr = ahead;

      }

      return prev;

    }

  ListNode * reverseEvenLengthGroups(ListNode * head) {
    ListNode * dummy = new ListNode(), * tail = dummy;

    int group = 1;
    while (head != nullptr) {
      ListNode * curr = head;

      ListNode * prev = head;

      int count = 0;

      while (curr != nullptr && count < group) {

        count++;

        if (count < group) curr = curr -> next;

      }

      if (count < group) {
        
         if(count %2 ==0){
             tail-> next = reverse(prev);
         }else{
             tail-> next = prev;
         }
        // tail -> next = prev;
        return dummy -> next;

      }

      if (count % 2 == 0) {
        // 1 + (count % 2 == 0) {
          head = curr -> next;

          curr -> next = nullptr;

          ListNode * reversed = reverse(prev);
          tail -> next = reversed;

          tail = prev;

        } else {

          tail -> next = prev;

          tail = curr;

          head = curr -> next;

          curr -> next = nullptr;

        }

        group++;

      }
    return dummy -> next;

  }
};