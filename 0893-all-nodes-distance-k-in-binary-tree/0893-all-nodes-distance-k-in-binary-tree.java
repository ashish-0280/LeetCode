/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int size = height(root);
        int n = (int)Math.pow(2, size);
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        buildGraph(root, graph);
        List<Integer> result = new ArrayList<>();
        boolean vis[] = new boolean[graph.size()];
        dfs(result, graph, vis, target.val, 0, k);
        return result;
    }
    public void dfs(List<Integer> result, List<List<Integer>> graph, boolean vis[], int curr, int level, int k){
        if(level == k){
            result.add(curr);
        }
        vis[curr] = true;
        for(int neighbour: graph.get(curr)){
            if(!vis[neighbour]){
                vis[neighbour] = true;
                dfs(result, graph, vis, neighbour, level+1, k);
            }
        }
    }
    public void buildGraph(TreeNode root, List<List<Integer>> graph){
        if(root == null){
            return;
        }
        if(root.left != null){
            graph.get(root.val).add(root.left.val);
            graph.get(root.left.val).add(root.val);
        }
        if(root.right != null){
            graph.get(root.val).add(root.right.val);
            graph.get(root.right.val).add(root.val);
        }
        buildGraph(root.left, graph);
        buildGraph(root.right, graph);
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}