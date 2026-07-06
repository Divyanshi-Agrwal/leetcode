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
    public ListNode reverseList(ListNode head) {
        //  ListNode prev = null;
        // ListNode current = head;
        // while(current != null){
        //     ListNode next = current.next;
        //     current.next = prev;
        //     prev = current;
        //     current = next;

        // }
        // return prev;
             // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the remaining list
        ListNode newHead = reverseList(head.next);

        // Reverse the current link
        head.next.next = head;
        head.next = null;

        return newHead;


        
    }
}