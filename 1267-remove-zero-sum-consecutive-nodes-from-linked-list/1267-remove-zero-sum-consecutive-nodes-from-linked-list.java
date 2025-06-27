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
    int arr[] = new int[2];
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode ls1 = func(head);
        ListNode ls2 = func(ls1);
        ListNode ls3 = func(ls2);
        ListNode ls4 = func(ls3);
        ListNode ls5 = func(ls4);
        ListNode ls6 = func(ls5);
        ListNode ls7 = func(ls6);
        ListNode ls8 = func(ls7);
        ListNode ls9 = func(ls8);
        ListNode ls10 = func(ls9);
        ListNode ls11 = func(ls10);
        return ls11;
        
    }
    public ListNode func(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        if(checkp(list) || checkn(list)) {
            ListNode node = new ListNode(0);
            ListNode tail = node;
            for(int i=0; i<list.size(); i++){
                if(list.get(i) == 0) continue;
                tail.next = new ListNode(list.get(i));
                tail = tail.next;
            }
            return node.next;
        }
        solve(list);
        ListNode node = new ListNode(0);
        ListNode tail = node;
        int start = arr[0]; int end = arr[1];
        for(int i=0; i<list.size(); i++){
            if(i >=start && i <= end) continue;
            if(list.get(i) == 0) continue;
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }
        solve(list);
        
        return node.next;
        
    }
    public boolean checkp(List<Integer> list){

        for(int num: list){
            if(num < 0) return false;
        }
        return true;
    }
    public boolean checkn(List<Integer> list){
        for(int num: list){
            if(num > 0) return false;
        }
        return true;
    }
    public void solve(List<Integer> list){
        int max = 0; arr[0] = -1; arr[1] = -1;
        for(int i=0; i<list.size()-1; i++){
            int sum = list.get(i);
            for(int j=i+1; j<list.size(); j++){
                sum += list.get(j);
                if(sum == 0){
                    if(max < j-i+1){
                        max = j-i+1;
                        arr[0] = i; arr[1] = j;
                    }
                }
            }
        }
    }
}