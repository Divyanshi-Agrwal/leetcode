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

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;
        int first = -1;
        int prevCritical = -1;
        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {

            int nextValue = curr.next.val;

            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > nextValue) ||
                (curr.val < prev.val && curr.val < nextValue)) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // Distance from previous critical point
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, position - prevCritical);
                }

                prevCritical = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        // Need at least two critical points
        if (first == prevCritical) {
            return ans;
        }

        int maxDist = prevCritical - first;

        ans[0] = minDist;
        ans[1] = maxDist;

        return ans;
    }
}