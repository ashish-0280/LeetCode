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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode temp1 = head.next;
        ListNode l = new ListNode(0);
        ListNode tail = l;
        tail.next = new ListNode(temp.val);
        tail = tail.next;
        while(temp != null && temp1 != null){
            int value = gcd(temp.val, temp1.val);
            tail.next = new ListNode(value);
            tail = tail.next;
            tail.next = new ListNode(temp1.val);
            tail = tail.next;
            temp1 = temp1.next;
            temp = temp.next;
        }
        return l.next;
    }
    public int gcd(int a, int b){
        int min = Math.min(a,b);
        for(int i=min; i>=1; i--){
            if(a % i == 0 && b % i == 0){
                return i;
            }
        }
        return 1;
    }
}