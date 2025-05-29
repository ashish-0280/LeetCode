class Solution {
    Integer dp[][];
    public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for(int num: cuts){
            list.add(num);
        }
        dp = new Integer[cuts.length+1][cuts.length+1];
        list.addLast(n);
        list.addFirst(0);
        
        Collections.sort(list);
        return solve(list, 1, list.size()-2);
    }
    public int solve(List<Integer> list, int i, int j){
        if(i>j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int temp1 = solve(list, i, k-1);
            int temp2 = solve(list, k+1, j);
            int temp3 = list.get(j+1) - list.get(i-1);
            min = Math.min(min, temp1+temp2+temp3);
        }
        return dp[i][j] = min;
    }
}