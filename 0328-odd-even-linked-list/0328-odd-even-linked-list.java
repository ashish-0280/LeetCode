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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode t = temp2;
        while(temp1.next != null && temp2.next != null){
            if(temp1.next.next != null){
                temp1.next = temp1.next.next;
                temp1 = temp1.next;
            }
            if(temp2.next.next != null){
                temp2.next = temp2.next.next;
                temp2 = temp2.next;
            }
        }
        temp1.next = t;
        temp2.next = null;
        return head;
    }
}