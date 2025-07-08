class Solution {
    int[][] memo;
    int[][] events;
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        this.events = events;
        int n = events.length;
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, k);
    }
    
    private int dfs(int index, int k) {
        if (index == events.length || k == 0) return 0;
        
        if (memo[index][k] != -1) return memo[index][k];
        
        int skip = dfs(index + 1, k);
        
        // Option 2 → attend current event
        int nextIndex = findNext(index);
        int take = events[index][2] + dfs(nextIndex, k - 1);
        
        return memo[index][k] = Math.max(skip, take);
    }
    
    private int findNext(int index) {
        int lo = index + 1;
        int hi = events.length - 1;
        int ans = events.length;
        int currEnd = events[index][1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (events[mid][0] > currEnd) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
