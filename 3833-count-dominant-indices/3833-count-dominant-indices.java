class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        prefix[n] = 0;
        for(int i=n-1; i>=0; i--){
            prefix[i] = prefix[i+1] + nums[i];
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            int sum = prefix[i+1];
            int num = n -i - 1;
            if(num == 0) continue;
            int avg = sum /num;
            if(avg < nums[i]){
                cnt++;
            }
        }
        return cnt;
    }
}