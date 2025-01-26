class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, list, target, 0);
        return ans;
    }
    public void solve(int arr[], List<Integer> l, int target, int index){
        //Base Condition
        if(target == 0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            l.add(arr[i]);  
            solve(arr, l, target - arr[i], i + 1);  
            l.remove(l.size() - 1);
        }
    }
}