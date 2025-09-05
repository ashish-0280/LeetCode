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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        Stack <Integer> stk = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stk.push(temp.val);
            temp = temp.next;
        }
        ListNode l = new ListNode(stk.pop());
        ListNode tail = l;
        while(!stk.isEmpty()){
            int x = stk.pop();
            tail.next = new ListNode(x);
            tail = tail.next;
        }
        return l;
    }
}