/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA; ListNode temp2 = headB;
        int cnt1 = 0;
        while(temp1 != null){
            cnt1++;
            temp1 = temp1.next;
        }
        int cnt2 = 0;
        while(temp2 != null){
            cnt2++;
            temp2 = temp2.next;
        }
        temp1 = headA; temp2 = headB;
        while(cnt1 > cnt2){
            temp1 = temp1.next;
            cnt1--;
        }
        while(cnt1 < cnt2){
            temp2 = temp2.next;
            cnt2--;
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}