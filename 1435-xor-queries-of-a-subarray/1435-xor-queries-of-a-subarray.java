class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] ^ arr[i];
        }
        for(int i=0; i<queries.length; i++){
            ans[i] = queries[i][0] > 0 ? prefix[queries[i][0]-1] ^ prefix[queries[i][1]] : prefix[queries[i][1]];
        }
        return ans;
    }
}