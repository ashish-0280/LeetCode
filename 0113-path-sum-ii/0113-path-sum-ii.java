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
    int i=0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> current = new ArrayList<>();
        solve(list, root, targetSum, current);
        return list;
    }
    public void solve(List<List<Integer>> list, TreeNode root, int target, List<Integer> current){
        if(root == null){
            return;
        }
        current.add(root.val);
        if(target == root.val && root.left == null && root.right == null){
            list.add(new ArrayList<>(current));
        } else {
            solve(list, root.left, target-root.val, current);
            solve(list, root.right, target-root.val, current);
        }
        current.remove(current.size()-1);
    }
}