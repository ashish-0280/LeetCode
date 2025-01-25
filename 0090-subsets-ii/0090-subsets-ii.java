class Solution {
    Set <List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        solve(nums, list, 0);
        List <List<Integer>> resultt = new ArrayList<>(result);
        return resultt;
    }
    public void solve(int nums[], List<Integer> list, int i){
        if(i>=nums.length){
            List<Integer> ls = new ArrayList<>(list);
            Collections.sort(ls);
            result.add(ls);
            return;
        }
        list.add(nums[i]);
        solve(nums, list, i+1);
        list.remove(list.size()-1);
        solve(nums, list, i+1);
    }
}