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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    public TreeNode solve(int nums[], int i, int j){
        if(i > j) return null;
        int arr[] = getMax(nums, i, j);
        int idx = arr[0], max = arr[1];
        TreeNode root = new TreeNode(max);
        root.left = solve(nums, i, idx-1);
        root.right = solve(nums, idx+1, j);
        return root;
    }
    public int[] getMax(int nums[], int i, int j){
        int max = Integer.MIN_VALUE;
        int idx = -1; 
        for(int k=i; k<=j; k++){
            if(max < nums[k]){
                max = nums[k]; idx = k;
            }
        }
        return new int[]{idx, max};
    }
}