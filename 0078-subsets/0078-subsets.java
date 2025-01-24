class Solution {
    List <List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        solve(nums, list, 0);
        return result;
    }
    public void solve(int nums[], List<Integer> list, int i){
        if(i>=nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(nums, list, i+1);
        list.remove(list.size()-1);
        solve(nums, list, i+1);
    }
}