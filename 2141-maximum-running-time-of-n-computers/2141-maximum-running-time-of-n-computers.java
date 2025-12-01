class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length; long sum = 0;
        for(int battery: batteries){
            sum += battery;
        }
        long low = 0; long high = sum/n;
        long ans = 0;
        while(low <= high){
            long mid = (low + high)/2;
            if(check(batteries, mid, n)){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
    public boolean check(int batteries[], long mid, int n){
        long total = 0;
        for(int num: batteries){
            total += Math.min(mid, num);
        }
        return total >= mid * n;
    }
}
