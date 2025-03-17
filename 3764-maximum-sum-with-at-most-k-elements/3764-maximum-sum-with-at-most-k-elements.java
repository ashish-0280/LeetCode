class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                pq.add(new int[]{grid[i][j], i});
            }
        }
        System.out.println(pq);
        long sum = 0;
        while(k>0 && !pq.isEmpty()){
            int arr[] = pq.poll();
            if(limits[arr[1]] != 0){
                sum += arr[0];
            } else {
                continue;
            }
            limits[arr[1]]--; k--;
        }
        return sum;
    }
}