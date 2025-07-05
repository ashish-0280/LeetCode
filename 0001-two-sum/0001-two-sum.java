class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = -1; arr[1] = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            int needed = target-current;
            if(map.containsKey(needed)){
                arr[0] = i;
                arr[1] = map.get(needed);
                return arr;
            }
            map.put(current, i);
        }
        return arr;
    }
}