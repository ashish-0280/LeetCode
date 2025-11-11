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
    public boolean isPalindrome(ListNode head) {
        ListNode temp1 = head;
        List<Integer> list = new ArrayList<>();
        while(temp1 != null){
            list.add(temp1.val);
            temp1 = temp1.next;
        }
        temp1 = head;
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i) != temp1.val){
                return false;
            } 
            temp1 = temp1.next;
        }
        return true;
    }
}