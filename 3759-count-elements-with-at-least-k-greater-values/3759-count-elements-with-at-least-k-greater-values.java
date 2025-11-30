class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if(k == 0) return n;
        Arrays.sort(nums);
        int cnt = 0; 
        int i=0;
        while(i < n){
            int val = nums[i];
            int j = i;
            while(j < n && nums[j] == val) j++;
            int freq = j - i;
            int greater = n - j;
            if(greater >= k) {
                cnt += freq;
            }
            i = j;
        }
        
        return cnt;
    }
}