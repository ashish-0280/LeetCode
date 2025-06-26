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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list; int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                sublist.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(level % 2 != 0){
                Collections.reverse(sublist);
            }
            level++;
            list.add(sublist);
        }
        return list;
    }
}