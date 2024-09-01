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
    public int goodNodes(TreeNode root) {
        int cnt[] = new int[1];
        int max = root.val;
        solve(root, cnt, max);
        return cnt[0];
    }
    public void solve(TreeNode root, int cnt[], int max){
        if(root == null){
            return;
        }
        if(max <= root.val){
           cnt[0]++;
           max = root.val;
        }
        solve(root.left, cnt, max);
        solve(root.right, cnt, max);
    }
}