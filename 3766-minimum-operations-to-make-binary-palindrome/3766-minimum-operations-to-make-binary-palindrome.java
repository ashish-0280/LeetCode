class Solution {
    public int[] minOperations(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=1; i<=5000; i++){
            String s = Integer.toBinaryString(i);
            if(!solve(s)) continue;
            l.add(i);
        }
        int m = l.size();
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 5000);
        for(int i=0; i<n; i++){
            int low = 0; int high = m-1;
            while(low <= high){
                int mid = (low + high)/2;
                if(nums[i] == l.get(mid)){
                    ans[i] = 0; break;
                } else if(nums[i] < l.get(mid)){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            if (ans[i] != 0) {
                int best = Integer.MAX_VALUE;
                if (low < m)
                    best = Math.min(best, Math.abs(nums[i] - l.get(low)));
                if (high >= 0)
                    best = Math.min(best, Math.abs(nums[i] - l.get(high)));

                ans[i] = best;
            }

        }
        return ans;
    }
    public boolean solve(String s){
        int l = 0; int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}