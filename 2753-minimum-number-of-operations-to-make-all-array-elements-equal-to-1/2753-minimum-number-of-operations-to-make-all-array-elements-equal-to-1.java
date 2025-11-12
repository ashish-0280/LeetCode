class Solution {
    public int minOperations(int[] nums) {
        int a = nums[0]; int n = nums.length;
        int ones = 0;
        if(nums[0] == 1) ones++;
        for(int i=1; i<n; i++){
            if(nums[i] == 1){
                ones++;
            }
            a = gcd(a, nums[i]);
        }
        if(ones > 0) return n-ones;
        
        if(a != 1) return -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            for (int j = i; j < n; j++) {
                curr = gcd(curr, nums[j]);
                if (curr == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return (minLen - 1) + (n-1);
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}