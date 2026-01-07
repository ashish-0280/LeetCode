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
    long max = Long.MIN_VALUE;
    int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        long sum = totalSum(root);
        dfs(root, sum);
        return (int)(max % MOD);
    }
    public long dfs(TreeNode root, long sum){
        if(root == null) return 0;

        long left = dfs(root.left, sum);
        long right = dfs(root.right, sum);
        long currSum = left + right + root.val;
        max = Math.max(max, (sum - currSum) * currSum);
        return currSum;
    }
    public long totalSum(TreeNode root){
        if(root == null) return 0;
        long left = totalSum(root.left);
        long right = totalSum(root.right);
        return left + right + root.val;
    }
}