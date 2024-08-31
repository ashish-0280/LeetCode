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
    public int longestZigZag(TreeNode root) {
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        List <Integer> list = new ArrayList<>();
        solve(root, cnt, list);
        for(int i=0; i<list.size(); i++){
            max = Math.max(max, list.get(i));
        }
        return max;
    }
    public void solve(TreeNode root, int cnt, List<Integer> list){
        if(root == null){
            return;
        }
        TreeNode root1 = root;
        while(root1.left != null || root1.right != null){
            if(root1.left != null){
                root1 = root1.left;
                if(root1 != null){
                    cnt++;
                } else {
                    break;
                }
            } else {
                break;
            }
            if(root1.right != null){
                root1 = root1.right;
                if(root1 != null){
                    cnt++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        list.add(cnt);
        cnt = 0;
        root1 = root;

        while(root1.left != null || root1.right != null){
            if(root1.right != null){
                root1 = root1.right;
                if(root1 != null){
                    cnt++;
                } else {
                    break;
                }
            } else {
                break;
            }
            if(root1.left != null){
                root1 = root1.left;
                if(root1 != null){
                    cnt++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        list.add(cnt);
        cnt = 0;
        solve(root.left, cnt, list);
        solve(root.right, cnt, list);
    }
}