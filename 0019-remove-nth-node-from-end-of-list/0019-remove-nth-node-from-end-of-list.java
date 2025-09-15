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
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int idx = list.size() - n;
        list.remove(idx);
        ListNode l = new ListNode(0);
        ListNode tail = l;
        for(int i=0; i<list.size(); i++){
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }
        return l.next;
    }
}