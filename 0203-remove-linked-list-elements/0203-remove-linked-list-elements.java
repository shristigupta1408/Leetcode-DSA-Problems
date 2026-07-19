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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = head;
        ListNode prev = dummy;

        while (currNode != null) {
            if (currNode.val == val) prev.next = currNode.next;
            else prev = currNode;

            currNode = currNode.next;
        }

        return dummy.next;
    }
}