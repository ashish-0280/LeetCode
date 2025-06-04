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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode head = l;
        int carry = 0; int digit = 0;
        while(l1 != null && l2 != null){
            int x = l1.val;
            int y = l2.val;
            int sum = x + y + carry; 
            digit = sum;
            if(digit > 9){
                digit = digit % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l.next = new ListNode(digit);
            l = l.next;
            l1 = l1.next; l2 = l2.next;
        }
        while(l1 != null){
            digit = l1.val + carry;
            if(digit > 9){
                digit = digit % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l.next = new ListNode(digit);
            l = l.next;
            l1 = l1.next;
        }
        while(l2 != null){
            digit = l2.val + carry;
            if(digit > 9){
                digit = digit % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l.next = new ListNode(digit);
            l = l.next;
            l2 = l2.next;
        }
        if(carry == 1){
            l.next = new ListNode(1);
            l = l.next;
        }
        return head.next;
    }
}