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
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        String value = String.valueOf(root.val);
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if(root.left == null && root.right == null){
            return value;
        }
        if(root.left == null){
            return value + "()" + "(" + right + ")";
        } else if(root.right == null){
             return value+"("+left+")";
        }
        return value + "(" + left + ")"+"(" + right + ")"; 
    }
}