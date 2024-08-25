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
    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> list = new ArrayList<>();
        helper(list, root, 0);
        return list;
    }
    public void helper(List<Integer> list, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        helper(list, root.right, level+1);
        helper(list, root.left, level+1);
    }
}