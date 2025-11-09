class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeSet<Integer>> map2 = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(!map2.containsKey(nums[i])){
                map2.put(nums[i], new TreeSet<>());
            }
            map2.get(nums[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int val = entry.getValue(); int key = entry.getKey();
            if(val < 3) continue;
            min = Math.min(min, minValue(map2.get(key)));
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public int minValue(TreeSet<Integer> set) {
        if (set.size() < 3) return -1; // not enough elements

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