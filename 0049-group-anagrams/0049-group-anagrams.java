class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        boolean vis[] = new boolean[strs.length]; int k = 0;
        for(int i=0; i<strs.length; i++){
            if(vis[i]) continue;
            vis[i] = true;
            ans.add(new ArrayList<>());
            ans.get(k).add(strs[i]);
            for(int j=i+1; j<strs.length; j++){
                if(isAnagram(strs[i], strs[j])){
                    vis[j] = true;
                    ans.get(k).add(strs[j]);
                }
            }
            k++;
        }
        return ans;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int freq[] = new int[26];
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int num: freq){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}