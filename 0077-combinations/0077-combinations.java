class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i=1; i<=n; i++){
            l.add(i);
        }
        List<Integer> sublist = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        solve(l, list, sublist, 0, k);
        return list;
    }
    public void solve(List<Integer> l, List<List<Integer>> list, List<Integer> sublist, int idx, int k){
        if(sublist.size() == k){
            list.add(new ArrayList<>(sublist));
            return;
        }
        if(idx>=l.size()){
            return;
        }
        sublist.add(l.get(idx)); 
        solve(l, list, sublist, idx+1, k);  
        sublist.remove(sublist.size() - 1);  
        solve(l, list, sublist, idx+1, k); 
    }
}