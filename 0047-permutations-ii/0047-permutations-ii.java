class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for(int num: nums){
            l.add(num);
        }
        solve(list, 0, l);
        List<List<Integer>> lis = new ArrayList<>(list);
        return lis;
    }
    public void solve(Set<List<Integer>> list, int j, List<Integer> l){
        if(j==l.size()){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=j; i<l.size(); i++){
            swap(l, i, j);
            solve(list, j+1, l);
            swap(l, i, j);
        }
    }
    public void swap(List<Integer> l, int i, int j){
        int temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }
}