class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        int freq[] = new int[26];
        solve(arr, new StringBuilder(), 0, freq);
        return max;
    }
    public void solve(List<String> arr, StringBuilder sb, int idx, int freq[]){
        max = Math.max(max, sb.length());
        for(int i=idx; i<arr.size(); i++){
            if(!check(arr.get(i), freq)){
                continue;
            }
            for(char ch: arr.get(i).toCharArray()){
                    freq[ch-'a']++;
                }
            sb.append(arr.get(i));
            solve(arr, sb, i+1, freq);
            sb.delete(sb.length()-arr.get(i).length(), sb.length());
            for(char ch: arr.get(i).toCharArray()){
                freq[ch-'a']--;
            }
        }
    }
    public boolean check(String word, int[] freq) {
        int[] temp = new int[26];
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (freq[idx] > 0 || temp[idx]++ > 0) return false;
        }
        return true;
    }
}