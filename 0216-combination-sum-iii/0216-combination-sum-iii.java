class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = new int[9];
        for(int i=1; i<10; i++){
            arr[i-1] = i;
        }
        List<Integer> list = new ArrayList<>();
        solve(arr, list, n, arr.length-1, k);
        
        return ans;
    }
    public void solve(int arr[], List<Integer> l, int target, int i, int k){
        //Base Condition
        if(target == 0 && k == l.size()){
            ans.add(new ArrayList<>(l));
            return;
        } 
        if(i<0 || target<0){
            return;
        }
        l.add(arr[i]);
        solve(arr, l, target-arr[i], i-1, k);
        l.remove(l.size()-1);
        solve(arr, l, target, i-1, k);
    }
}