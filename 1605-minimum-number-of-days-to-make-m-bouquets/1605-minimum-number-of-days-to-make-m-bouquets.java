class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int i=1; int j=findMax(bloomDay);
        int ans = -1;
        while(i<=j){
            int mid = (i+j)/2;
            if(solve(bloomDay, m, k, mid)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public int findMax(int nums[]){
        int max = -1;
        for(int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
    public boolean solve(int bloomDay[], int m, int k, int mid){
        int sum = 0; int prev = -1; int cnt = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(i-prev != 1) sum = 0;
            if(bloomDay[i] <= mid){
                sum++;
                prev = i;
                if(sum == k){
                    cnt++;
                    sum = 0;
                    if(cnt == m) return true;
                }
            }
        }
        return false;
    }
}