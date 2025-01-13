class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map <Integer, Integer> map = new HashMap<>();
        double n = Math.floor(nums.length/3);
        for(int i=0; i<nums.length ; i++){
        
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            
                if(map.get(nums[i])>n){
                    set.add(nums[i]);
                }
        }
        List<Integer> list = new ArrayList<>(set);
        return list;

    }
}