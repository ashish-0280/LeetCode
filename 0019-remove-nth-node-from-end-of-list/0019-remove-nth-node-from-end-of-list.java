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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int size = 0; ListNode temp = head;
        // while(temp != null){
        //     size++;
        //     temp = temp.next;
        // }
        // int idx = size - n;
        // if(idx == 0) return head.next;
        // temp = head;
        // while(idx > 1){
        //     idx--;
        //     temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;

        ListNode slow = head; ListNode fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}