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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;

        // Recursively get max path from left and right
        int left = Math.max(0, solve(root.left));   // ignore negative paths
        int right = Math.max(0, solve(root.right));

        // Possible max path **through** the root
        int currentPath = left + right + root.val;

        // Update the global max path if needed
        res = Math.max(res, currentPath);

        // Return the best path going **upwards**
        return Math.max(left, right) + root.val;
    }
}
