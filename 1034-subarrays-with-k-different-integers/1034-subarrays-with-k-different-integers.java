class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solveAtLeastKDistinct(nums, k) - solveAtLeastKDistinct(nums, k+1);
    }
    public int solveAtLeastKDistinct(int nums[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0; int j=0; int cnt = 0; int n = nums.length;
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size() == k){
                cnt += n-j;
                int num = nums[i];
                if(map.containsKey(num)){
                    map.put(num, map.get(num)-1);
                }
                if(map.get(num) == 0){
                    map.remove(num);
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
}