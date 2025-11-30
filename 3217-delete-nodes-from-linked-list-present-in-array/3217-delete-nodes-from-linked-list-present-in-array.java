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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set <Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        ListNode temp = head;
        while(temp != null){
            if(!set.contains(temp.val)){
                ListNode t = new ListNode(temp.val);
                tail.next = t;
                tail = t;
            }
            temp = temp.next;
        }
        return ans.next;
    }
}