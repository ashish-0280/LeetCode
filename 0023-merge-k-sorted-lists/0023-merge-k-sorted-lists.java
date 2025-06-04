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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return solve(lists, 0, lists.length-1);
    }
    public ListNode solve(ListNode[] lists, int i, int j){
        if(j-i == 1){
            return merge(lists[i], lists[j]);
        }
        if(j-i == 0) return lists[i];
        int mid = (i+j)/2;
        ListNode l1 = solve(lists, i, mid);
        ListNode l2 = solve(lists, mid+1, j);
        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode ans;
        if(l1.val <= l2.val){
            ans = l1;
            ans.next = merge(l1.next, l2);
        } else {
            ans = l2;
            ans.next = merge(l1, l2.next);
        }
        return ans;
    }
}