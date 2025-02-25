class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0, evenCount = 1;
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;
            
            if (prefixSum % 2 == 1) {
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return result;
    }
}