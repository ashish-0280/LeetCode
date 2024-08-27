class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i = 0;
        int j = k-1;
        int ans[] = new int[nums.length-(k-1)];
        while(j<nums.length){
            ans[i] = check(nums, i, j);
            i++;
            j++;
        }
        return ans;
    }
    public int check(int nums[], int i, int j){
        for(int p=i; p<j; p++){
            if(nums[p]>=nums[p+1] || nums[p+1]-nums[p] != 1){
                return -1;
            }
        }
        return nums[j];
    }
}