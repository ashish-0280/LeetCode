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
 import java.util.*;
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head; int size = 0;;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        size = size-1; temp = head;
        int binaryNumber = 0;
        while(temp != null && size >= 0){
            binaryNumber += Math.pow(2, size) * temp.val;
            temp = temp.next; size--;
        }
        return binaryNumber;
    }
}