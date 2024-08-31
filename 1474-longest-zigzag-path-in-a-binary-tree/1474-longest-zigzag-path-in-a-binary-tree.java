/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {
        int cnt = 0;
        solve(root, 0, false);
        solve(root, 0, true);
        return max;
    }
    public void solve(TreeNode root, int cnt, boolean isLeft){
        if(root == null){
            return;
        }
        max = Math.max(max, cnt);
        if(isLeft){
            solve(root.left, cnt+1, false);
            solve(root.right, 1, true);
        } else {
            solve(root.right, cnt+1, true);
            solve(root.left, 1, false);
        }
    }
}