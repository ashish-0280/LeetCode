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
            List<Integer> l = map.get(num);
            int n = l.size();
            if(n == 1){
                list.add(-1);
                continue;
            }
            else if(l.get(0) == idx){
                int dist = Math.min(l.get(1)-l.get(0), nums.length - l.get(n-1) + l.get(0));
                list.add(dist);
                continue;
            }
            else if(idx == l.get(n-1)){
                int dist = Math.min(l.get(n-1) - l.get(n-2), nums.length - l.get(n-1) + l.get(0));
                list.add(dist);
                continue;
            }
            int j = Collections.binarySearch(l, idx);
            list.add(Math.min(l.get(j)-l.get(j-1), l.get(j+1)-l.get(j)));
        }
        return list;
    }
}