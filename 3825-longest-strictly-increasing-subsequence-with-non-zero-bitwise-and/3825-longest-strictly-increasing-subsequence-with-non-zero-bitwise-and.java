class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int max = 0;
        int arr[] = new int[n]; 
        for(int i=0; i<30; i++){
            int idx = 0;
            for(int num: nums){
                if(((num >> i) & 1) == 1){
                    arr[idx] = num;
                    idx++;
                }
            }
            int len = lis(arr, idx);
            if(idx > max){
                max = Math.max(max, len);
            }
        }
        return max;
    }
    public int lis(int arr[], int idx){
        int dumy[] = new int[idx];
        int k = 0;
        for(int i=0; i<idx; i++){
            int target = arr[i]; int ans = k;
            int low = 0; int high = k-1;
            while(low <= high){
                int mid = (low + high)/2;
                if(dumy[mid] >= target){
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }   
            }
            if(ans == k){
                dumy[ans] = arr[i];
                k++;
            } else {
                dumy[ans] = arr[i];
            }
        }
        return k;
    }
}