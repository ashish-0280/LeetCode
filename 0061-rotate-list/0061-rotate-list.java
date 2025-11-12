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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0) return head;
        int diff = size - k;
        ListNode slow = head; ListNode fast = head;
        while(k-- > 0){
            fast = fast.next;
        }
        while(slow.next != null && fast.next != null){
            slow = slow.next; fast = fast.next;
        }
        temp = slow.next;
        slow.next = null;
        fast.next = head;
        return temp;
    }
}