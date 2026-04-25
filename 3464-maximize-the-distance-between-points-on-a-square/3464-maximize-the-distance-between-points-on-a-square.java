class Solution {
    public int maxDistance(int side, int[][] points, int k) {

        int n = points.length;
        long arr[] = new long[n];
        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];

            if(y == 0){
                arr[i] = x;
            } else if(x == side){
                arr[i] = side + y;
            } else if(y == side){
                arr[i] = 3L * side - x;
            } else {
                arr[i] = 4L * side - y;
            }
        }

        Arrays.sort(arr);

        long circular[] = new long[2 * n];
        long perimeter = 4L * side;
        for(int i=0; i<n; i++){
            circular[i] = arr[i];
            circular[i+n] = perimeter + arr[i];
        }
        
        long low = 0; long high = 2L * side; long ans = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(check(circular, mid, side, k, n)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int)ans;
    }
    public boolean check(long arr[], long dist, int side, int k, int n){

        for(int i=0; i<n; i++){
            int count = 1;
            long start = arr[i];
            long end = arr[i];
            int idx = i;
            while(count < k){
                long target = end + dist;
                int next = lowerBound(arr, target, idx + 1, i + n);
                if(next >= i+n){
                    break;
                }
                end = arr[next];
                idx = next;
                count++;
            }
            if(count == k){
                long gap = (4L * side) - (end - start);
                if(gap >= dist) return true;
            }
        }
        return false;
    }
    public int lowerBound(long arr[], long target, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] >= target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}