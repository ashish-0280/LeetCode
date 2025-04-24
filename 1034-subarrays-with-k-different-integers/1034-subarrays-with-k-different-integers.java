class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solveAtMostKDistinct(nums, k) - solveAtMostKDistinct(nums, k-1);
    }
    public int solveAtMostKDistinct(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0; int j=0; int cnt = 0; int n = nums.length;
        while(j<n){
            if(map.getOrDefault(nums[j], 0) == 0){
                k--;
            }
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(k<0){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    k++;
                }
                i++;
            }
            cnt += j-i+1;
            j++;
        }
        return cnt;
    }
}