class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = findMin(ranks) * (long)cars * cars;
        while(low < high){
            long mid = (low + high)/2;
            if(solve(ranks, cars, mid)){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    public boolean solve(int ranks[], int cars, long n){
        long totalCars = 0;
        for(int rank: ranks){
            totalCars += (long) Math.sqrt(n/rank);
            if(totalCars >= cars){
                return true;
            }
        }
        return false;
    }
    public int findMin(int ranks[]){
        int min = Integer.MAX_VALUE;
        for(int num: ranks){
            min = Math.min(min, num);
        }
        return min;
    }
}