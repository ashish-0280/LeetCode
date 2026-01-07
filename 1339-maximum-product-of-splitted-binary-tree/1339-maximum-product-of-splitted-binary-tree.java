/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     long val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(long val) { this.val = val; }
 *     TreeNode(long val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long max = Long.MIN_VALUE;
    int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        long p = sum3(root);
        sum(root, p);
        return (int)(max % mod);
    }

    public long sum(TreeNode root, long p){
        if(root == null) return 0;
        long sum1 = sum(root.left, p);
        long sum2 = sum(root.right, p);
        long res1 = (p - sum1) * sum1;
        long res2 = (p - sum2) * sum2;
        max = Math.max(max, Math.max(res1, res2));
        return sum1 + sum2 + root.val;
    }
    public long sum3(TreeNode root){
        if(root == null) return 0;
        long sum1 = sum3(root.left);
        long sum2 = sum3(root.right);
        return sum1 + sum2 + root.val;
    }
}