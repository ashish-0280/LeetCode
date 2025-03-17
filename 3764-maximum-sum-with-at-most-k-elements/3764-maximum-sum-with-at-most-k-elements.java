class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long max = 0;
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for(int i=0; i<grid.length; i++){
            list.add(new PriorityQueue<>(Collections.reverseOrder()));
            for(int j=0; j<grid[0].length; j++){
                list.get(i).add(grid[i][j]);
            }
        }
        while(k>0){
            long currMax = 0; int p=-1;
            for(int i=0; i<list.size(); i++){
                if(limits[i] == 0) continue;
                if(!list.get(i).isEmpty() && list.get(i).peek() > currMax){
                    currMax = list.get(i).peek();
                    p = i;
                }
            }
            if(p == -1) break;
            max += (long)list.get(p).poll();
            limits[p]--;
            k--;
        }
        return max;
    }
}