class Solution {
    //Set <List<Integer>> set = new HashSet<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        solve(candidates, list, target, candidates.length-1);
        
        return ans;
    }
    public void solve(int arr[], List<Integer> l, int target, int i){
        //Base Condition
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        } 
        if(i<0 || target<0){
            return;
        }
        l.add(arr[i]);
        solve(arr, l, target-arr[i], i);
        l.remove(l.size()-1);
        solve(arr, l, target, i-1);
    }
}