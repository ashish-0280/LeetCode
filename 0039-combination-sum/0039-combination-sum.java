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
        if(target < 0 || idx == arr.length){
            return;
        }
        sublist.add(arr[idx]);
        solve(list, arr, target-arr[idx], sublist, idx);
        sublist.remove(sublist.size() - 1);
        solve(list, arr, target, sublist, idx+1);
    }
}