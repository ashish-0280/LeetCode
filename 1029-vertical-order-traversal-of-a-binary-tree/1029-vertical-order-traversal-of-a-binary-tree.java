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
    List<int[]> ls = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        solve(root, 0, 0);
         Collections.sort(ls, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];        
            else if (a[1] != b[1]) return a[1] - b[1];   
            else return a[2] - b[2];                     
        });
        List<List<Integer>> list = new ArrayList<>();
         int prevCol = Integer.MIN_VALUE;
        List<Integer> currList = new ArrayList<>();

        for (int[] entry : ls) {
            int col = entry[0], val = entry[2];
            if (col != prevCol) {
                if (!currList.isEmpty()) list.add(new ArrayList<>(currList));
                currList.clear();
                prevCol = col;
            }
            currList.add(val);
        }

        list.add(currList); 
        return list;
    }
    public int height(TreeNode root){
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public void solve(TreeNode root, int first, int second){
        if(root == null) return;

        ls.add(new int[]{first, second, root.val});
        solve(root.left, first-1, second+1);
        solve(root.right, first+1, second+1);
    }
}