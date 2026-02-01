class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        cost += list.get(0); 
        cost += list.get(1);
        return cost;
    }
}