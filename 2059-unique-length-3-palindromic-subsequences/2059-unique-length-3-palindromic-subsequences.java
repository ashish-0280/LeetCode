class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length(); int ans = 0;
        for(int i=0; i < n-2; i++){
            if(set.contains(s.charAt(i))) continue;
            int j = n-1;
            while(j > i + 1){
                if(s.charAt(i) == s.charAt(j)){
                    set.add(s.charAt(i));
                    ans += distinct(s, i, j);
                    break;
                }
                j--;
            }
        }
        return ans;
    }
    public int distinct(String s, int i, int j){
        Set<Character> set = new HashSet<>();
        for(int k=i+1; k<j; k++){
            set.add(s.charAt(k));
        }
        return set.size();
    }
}