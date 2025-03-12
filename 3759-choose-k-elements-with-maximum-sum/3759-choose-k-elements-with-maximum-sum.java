class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int arr[][] = new int[n][3];
        for(int i=0; i<n; i++){
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
            arr[i][2] = i;
        }
        long sum = 0;
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        long ans[] = new long[n];
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(i>0 && arr[i-1][0] == arr[i][0]){
                ans[arr[i][2]] = ans[arr[i-1][2]];
            } else {
                ans[arr[i][2]] = sum;
            }
            sum += arr[i][1];
            pq.add(arr[i][1]);
            while(pq.size() > k){
                sum = sum - pq.remove();
            }
        }
        return ans;
    }
}