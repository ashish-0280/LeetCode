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
            temp = temp1;
            temp1 = temp1.next;
        }
        return head;
    }
    public int gcd(int a, int b){
        //Euclidean algorithm to find gcd of a, b
        //it says the gcd og (a, b) is same as gcd of((b, a%b));
        while(b != 0){
            int restoredValue = b;
            b = a % b;
            a = restoredValue;
        }
        return a;
    }
}