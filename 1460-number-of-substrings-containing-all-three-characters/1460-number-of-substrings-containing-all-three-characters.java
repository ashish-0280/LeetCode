class Solution {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int i=0; 
        int n = s.length();
        int arr[] = new int[3];
        for(int j=0; j<s.length(); j++){
            char ch = s.charAt(j);
            arr[ch-'a']++;
            while(arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1){
                cnt += n-j;
                arr[s.charAt(i)-'a']--; i++;
            }
        }
        return cnt;
    }
}