class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
                continue;
            }
            map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for(int i=0; i<queries.length; i++){
            int idx = queries[i];
            int num = nums[idx];
            int n = map.get(num).size();
            if(n == 1){
                list.add(-1);
                continue;
            }
            else if(map.get(num).get(0) == idx){
                int dist = Math.min(map.get(num).get(1)-map.get(num).get(0), nums.length - map.get(num).get(n-1) + map.get(num).get(0));
                list.add(dist);
                continue;
            }
            else if(idx == map.get(num).get(n-1)){
                int dist = Math.min(map.get(num).get(n-1) - map.get(num).get(n-2), nums.length - map.get(num).get(n-1) + map.get(num).get(0));
                list.add(dist);
                continue;
            }
            int j = Collections.binarySearch(map.get(num), idx);
            list.add(Math.min(map.get(num).get(j)-map.get(num).get(j-1), map.get(num).get(j+1)-map.get(num).get(j)));
        }
        return list;
    }
}