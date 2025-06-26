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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack <TreeNode> s1 = new Stack<>();
        Stack <TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode popped = s1.pop();
            if(popped != null){
                s2.push(popped);
            }
            if(popped.left != null){
                s1.push(popped.left);
            }
            if(popped.right != null){
                s1.push(popped.right);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
}