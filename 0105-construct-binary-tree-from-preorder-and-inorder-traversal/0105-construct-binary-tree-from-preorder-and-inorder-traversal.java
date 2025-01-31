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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx[] = new int[1];
        return solve(preorder, inorder, 0, preorder.length-1, idx);
    }
    public TreeNode solve(int preorder[], int inorder[], int start, int end, int idx[]){
        if(start > end) return null;
        if(idx[0] > preorder.length-1) return null;
        int data = preorder[idx[0]];
        int i = start;
        while(i<=end){
            if(inorder[i] == data){
                break;
            }
            i++;
        }
        idx[0]++;
        TreeNode root = new TreeNode(data);
        root.left = solve(preorder, inorder, start, i-1, idx);
        root.right = solve(preorder, inorder, i+1, end, idx);
        return root;
    }
}