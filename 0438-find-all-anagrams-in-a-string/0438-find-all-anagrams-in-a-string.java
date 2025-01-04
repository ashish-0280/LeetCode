class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int arr[] = new int[26];
        Arrays.fill(arr, 0);

        char pa[] = p.toCharArray();
        int k = pa.length;

        for(int i=0; i<k; i++){
            arr[pa[i] - 'a']++;
        }
        int i=0, j=0;
        while(i<s.length()){
            while(j<s.length() && j-i+1<=k){
                arr[s.charAt(j)-'a']--;
                if(j-i+1 == k){
                    if(allZero(arr)){
                        result.add(i);
                    }
                }
                j++;
            }
            arr[s.charAt(i)-'a']++;
            i++;
        } 
        return result;
    }
    public boolean allZero(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}