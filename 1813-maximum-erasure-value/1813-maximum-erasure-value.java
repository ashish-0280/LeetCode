class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0; int sum = 0;
        int i=0; int j=0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        while(j<n){
            int num = nums[j];
            while(set.contains(num)){
                set.remove(nums[i]);
                sum = sum - nums[i];
                i++;
            }
            set.add(num);
            sum = sum + num;
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}