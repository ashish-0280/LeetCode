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
    class Pair{
        TreeNode node;
        int dist;
        Pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair p = getLCA(root, 0);
        return p.node;
    }
    public Pair getLCA(TreeNode root, int d){
        if(root == null) return new Pair(null, d);
        Pair l = getLCA(root.left, d+1);
        Pair r = getLCA(root.right, d+1);
        if(l.dist == r.dist){
            return new Pair(root, l.dist);
        } else {
            return l.dist > r.dist ? l : r;
        }
    }
}