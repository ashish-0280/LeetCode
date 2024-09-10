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
        while(temp != null && temp1 != null){
            int value = gcd(temp.val, temp1.val);
            ListNode p = new ListNode(value);
            temp.next = p;
            p.next = temp1;
            temp = temp.next.next;
            temp1 = temp1.next;
        }
        return head;
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