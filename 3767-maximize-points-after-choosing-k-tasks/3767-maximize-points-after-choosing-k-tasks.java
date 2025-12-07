class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length; long ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        });
        for(int i=0; i<n; i++){
            if(technique1[i] >= technique2[i]){ 
                ans += technique1[i];
                k--;
            } else {
                pq.add(new int[]{i, technique2[i] - technique1[i]});
            }
        }
        while(!pq.isEmpty()){
            int x[] = pq.poll();
            if(k > 0){
                ans += technique1[x[0]]; 
                k--;
                continue;
            }
            ans += technique2[x[0]];
        }
        return ans;
    }
}