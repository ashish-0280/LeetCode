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
class FindElements {
   HashSet<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        solve(root);
        set.add(0);
    }
    public void solve(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            int x = root.val * 2 + 1;
            root.left.val = x;
            set.add(x);
        }
        if(root.right != null){
            int y = root.val * 2 + 2;
            root.right.val = y;
            set.add(y);
        }
        solve(root.left);
        solve(root.right);
    }
    public boolean find(int target) {
       return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */