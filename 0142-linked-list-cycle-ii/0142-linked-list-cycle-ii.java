/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int flag = 0;
        if(head == null){
            return null;
        } else if(head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            return null;
        } else {
            if(slow == head && fast == head){
                return slow;
            }
            slow = head;
            while(slow!=fast){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}