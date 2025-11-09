class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeSet<Integer>> indices = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(!indices.containsKey(nums[i])){
                indices.put(nums[i], new TreeSet<>());
            }
            indices.get(nums[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int val = entry.getValue(); int key = entry.getKey();
            if(val < 3) continue;
            min = Math.min(min, minValue(indices.get(key)));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int minValue(TreeSet<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i + 2 < list.size(); i++) {
            int x = list.get(i);
            int y = list.get(i + 1);
            int z = list.get(i + 2);
            int cost = Math.abs(x - y) + Math.abs(y - z) + Math.abs(z - x);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
}