class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        if(k == 1){
            return nums;
        }
        int ans[] = new int[nums.length-(k-1)];
        Arrays.fill(ans, -1);
        while(i<nums.length){
            while(j<i+k-1){
                if(j == nums.length-1){
                    break;
                }
                if(nums[j+1]-nums[j] == 1){
                    j++;
                } else {
                    i = j;
                    j = j+1;
                    break;
                }
                if(j == i+k-1){
                    ans[i] = nums[j];
                }
            }   
           
            i++;
        }
        return ans;
    }
    public int check(int nums[], int i, int j){
        
        return nums[j];
    }
}