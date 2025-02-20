class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        List <String> list = new ArrayList<>();
        List <String> l = new ArrayList<>();
        solve(list, new StringBuilder(), 0, n);
        for(int i=0; i<nums.length; i++){
            l.add(nums[i]);
        }
        for(int i=0; i<list.size(); i++){
            if(!l.contains(list.get(i))){
                return list.get(i);
            }
        }
        return "";
    }
    public void solve(List<String> list, StringBuilder s, int idx, int n){
        if(s.length() == n){
            list.add(s.toString());
            return;
        }
        if(idx > n){
            return;
        }
        for(char i='0'; i<='1'; i++){
            solve(list, s.append(i), idx+1, n);
            s.deleteCharAt(s.length()-1);
        }
    }
}