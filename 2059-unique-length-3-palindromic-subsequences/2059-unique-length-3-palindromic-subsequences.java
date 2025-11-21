class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length(); int ans = 0;
        int i=0; int j = n-1;
        while(i < n-2){
            if(set.contains(s.charAt(i))) {
                i++; continue;
            }
            j = n-1;
            while(j > i + 1){
                if(s.charAt(i) == s.charAt(j)){
                    set.add(s.charAt(i));
                    ans += distinct(s, i, j);
                    break;
                }
                j--;
            }
            i++;
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