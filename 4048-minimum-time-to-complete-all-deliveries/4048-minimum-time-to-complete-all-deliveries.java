class Solution {
    public long minimumTime(int[] d, int[] r) {
        long low = 0;
        long high = (long)(d[0] + d[1]) * Math.max(r[0], r[1]);
        long ans = 0;
        long l = lcm(r[0], r[1]);

        while(low <= high){
            long mid = low + (high - low)/2;
            if(check(d, r, mid, l)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int d[], int r[], long mid, long l){
        long x = mid / r[0]; 
        long y = mid / r[1];
        long together = mid / l;

        long drone1 = Math.max(0, y - together);
        long drone2 = Math.max(0, x - together);
        long anyone = mid - (x + y - together);

        long needed1 = Math.max(0, d[0] - drone1);
        long needed2 = Math.max(0, d[1] - drone2);

        return (needed1 + needed2) <= anyone;
    }

    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }
}
