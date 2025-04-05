class Solution {
    public int subsetXORSum(int[] nums) {
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        solve(nums, list, new ArrayList<>(), 0);
        for(int i=0; i<list.size(); i++){
            if(list.get(i).size() == 0) continue;
            int xor = list.get(i).get(0);
            for(int j=1; j<list.get(i).size(); j++){
                xor ^= list.get(i).get(j);
            }
            sum += xor;
        }
        return sum;
    }
    public void solve(int nums[], List<List<Integer>> list, List<Integer> sublist, int idx){
        if(idx >= nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[idx]);
        solve(nums, list, sublist, idx+1);
        sublist.remove(sublist.size()-1);
        solve(nums, list, sublist, idx+1);
    }
}