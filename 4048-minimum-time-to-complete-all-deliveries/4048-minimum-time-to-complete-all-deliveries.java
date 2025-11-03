class Solution {
    public long minimumTime(int[] d, int[] r) {
        long low = 0;
        long high = (long)(d[0] + d[1]) * Math.max(r[0], r[1]);
        long l = lcm(r[0], r[1]);

        while(low < high){
            long mid = low + (high - low) / 2;
            if(check(d, r, mid, l)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] d, int[] r, long mid, long l){
        long x = mid / r[0];
        long y = mid / r[1];
        long both = mid / l;

        long drone1 = Math.max(0, y - both);
        long drone2 = Math.max(0, x - both);
        long idle = mid - (x + y - both);

        long needed1 = Math.max(0, d[0] - drone1);
        long needed2 = Math.max(0, d[1] - drone2);

        return (needed1 + needed2) <= idle;
    }

    public long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }
}
