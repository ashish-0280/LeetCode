class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solve(list, candidates, target, new ArrayList<>(), 0);
        return list;
    }
    public void solve(List<List<Integer>> list, int arr[], int target, List<Integer> sublist, int idx){
        if(target == 0){
            list.add(new ArrayList<>(sublist));
            return;
        }
        if(idx == arr.length || target < 0) return;
        for(int i=idx; i<arr.length; i++){
            sublist.add(arr[i]);
            solve(list, arr, target - arr[i], sublist, i);
            sublist.remove(sublist.size()-1);
        }
    }
}