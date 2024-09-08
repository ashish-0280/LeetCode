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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null){
           return new ListNode[3];
        }
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        temp = head;
        if(cnt <= k){
            ListNode[] list = new ListNode[k];
            for(int i=0; i<list.length; i++){
                ListNode l = new ListNode(head.val);
                list[i] = l;
                head = head.next;
                if(head == null){
                    return list;
                }
            }
            return list;
        }
        int rem = cnt % k;
        int div = cnt/k;
        int p = 0;
        ListNode temp2 = head;
        ListNode[] list = new ListNode[k];
            for(int i=0; i<k; i++){
                ListNode l = new ListNode(0);
                ListNode tail = l;
                while(temp != null && p < div){
                    tail.next = new ListNode(temp.val);
                    tail = tail.next;
                    temp = temp.next;
                    p++;
                }
                if(rem != 0){
                    tail.next = new ListNode(temp.val);
                    tail = l.next;
                    temp = temp.next;
                    rem--;
                }
                list[i] = l.next;
                p = 0;
            }
        return list;
    }
}