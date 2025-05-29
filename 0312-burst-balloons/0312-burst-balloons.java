class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        dp = new Integer[nums.length+1][nums.length+1];
        list.addFirst(1);
        list.addLast(1);
        return solve(list, 1, list.size()-2);
    }
    public int solve(List<Integer> list, int i, int j){
        if(i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            int temp1 = solve(list, i, k-1);
            int temp2 = solve(list, k+1, j);
            int temp3 = list.get(i-1)*list.get(k)*list.get(j+1);
            max = Math.max(max, temp1+temp2+temp3);
        }
        return dp[i][j] = max;
    }
}