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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ListNode temp = list1;
        // List<Integer> list = new ArrayList<>(); 
        // while(temp != null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }
        // temp = list2;
        // while(temp != null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }
        // Collections.sort(list);
        // ListNode l = new ListNode(0);
        // ListNode tail = l;
        // for(int num: list){
        //     tail.next = new ListNode(num);
        //     tail = tail.next;
        // }
        // return l.next;
        ListNode temp1 = list1; ListNode temp2 = list2;
        ListNode l = new ListNode(0);
        ListNode tail = l;
        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                tail.next = new ListNode(temp1.val);
                tail = tail.next; temp1 = temp1.next;
            } else {
                tail.next = new ListNode(temp2.val);
                tail = tail.next; temp2 = temp2.next;
            }
        }
        while(temp1 != null){
            tail.next = new ListNode(temp1.val);
            tail = tail.next; temp1 = temp1.next;
        }
        while(temp2 != null){
            tail.next = new ListNode(temp2.val);
            tail = tail.next; temp2 = temp2.next;
        }
        return l.next;
    }
}