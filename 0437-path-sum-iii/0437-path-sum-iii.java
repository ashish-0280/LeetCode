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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int arr[] = new int[1];
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            solve(curr, targetSum, 0, arr);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return arr[0];
    }
    public void solve(TreeNode root, int target, long currSum, int arr[]){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(target == currSum){
            arr[0]++;
        }
        solve(root.left, target, currSum, arr);
        solve(root.right, target, currSum, arr);
    }
}