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
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int ans[][] = new int[m][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = m-1;
        int endCol = n-1;
        ListNode temp = head;
        for(int[] rows: ans){
            Arrays.fill(rows, -1);
        }
        while(endRow >= startRow && endCol >= startCol){
            for(int i=startCol; i<=endCol; i++){
                if(startCol<=endCol && startRow<=endRow){
                    if(temp != null){
                        ans[startRow][i] = temp.val;
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
            }
            for(int i=startRow+1; i<=endRow; i++){
                if(startCol<=endCol && startRow<=endRow){
                    if(temp != null){
                        ans[i][endCol] = temp.val;
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
            }
            for(int i=endCol-1; i>=startCol; i--){
                if(startCol<=endCol && startRow<=endRow){
                if(temp != null){
                        ans[endRow][i] = temp.val;
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
            }
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol<=endCol && startRow<=endRow){
                    if(temp != null){
                        ans[i][startCol] = temp.val;
                        temp = temp.next;
                    } else {
                        break;
                    }
                }
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return ans;
    }
}