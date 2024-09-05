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
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        HashMap <Long, Integer> hm = new HashMap<>();
        hm.put(0l,1);
        solve(root, targetSum, 0, hm);
        return cnt;
    }
    public void solve(TreeNode root, int target, long currSum, Map<Long, Integer> hm){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(hm.containsKey(currSum-target)){
            cnt += hm.get(currSum-target);
            System.out.println(hm);
            System.out.println(currSum-target);
        }
        hm.put(currSum, hm.getOrDefault(currSum, 0)+1);
        solve(root.left, target, currSum, hm);
        solve(root.right, target, currSum, hm);
        hm.put(currSum, hm.getOrDefault(currSum, 1)-1);
    }
}