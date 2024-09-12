class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int len = words.length;
        int arr[] = new int[26];
        for(char c: allowed.toCharArray()){
            arr[c-'a']++;
        }
        for(String word: words){
            for(char c: word.toCharArray()){
                if(arr[c-'a'] == 0){
                    len--;
                    break;
                }
            }
        }
        return len;
    }
}