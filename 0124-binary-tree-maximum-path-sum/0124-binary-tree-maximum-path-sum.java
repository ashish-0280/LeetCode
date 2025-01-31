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
    public int maxPathSum(TreeNode root) {
        Sum(root);
        return max;
    }
    public int Sum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum1 = Math.max(0, Sum(root.left));
        int sum2 = Math.max(0, Sum(root.right));
        max = Math.max(max, sum1 + sum2 + root.val);
        return Math.max(sum1, sum2) + root.val;
    }
}