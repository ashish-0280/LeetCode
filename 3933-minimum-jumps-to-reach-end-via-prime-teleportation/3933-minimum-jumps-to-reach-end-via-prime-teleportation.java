class Solution {
    static int MAX = 1000000;
    static int[] primes = new int[MAX + 1];
    static {
        for (int i = 2; i <= MAX; ++i) {
            if (primes[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    if (primes[j] == 0) primes[j] = i;
                }
            }
        }
    }
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>>hm = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            while (v > 1) {
                int p = primes[v];
                hm.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (v % p == 0) v /= p;
            }
        }
        boolean []vis=new boolean [n];
        PriorityQueue<int []> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int []{0,0});
        vis[0]=true;
        while (!q.isEmpty()) {
                int[] arr = q.poll();
            if(arr[0]==n-1)return arr[1];
            int idx=arr[0];
            int steps=arr[1]+1;
                if (idx + 1 < n && !vis[idx+1]) {
                    vis[idx+1]=true;
                    q.add(new int[]{idx + 1,steps});
                }
                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;;
                    q.add(new int []{idx - 1,steps});
                }
                int v = nums[idx];
                if(hm.containsKey(v)){
                for(int z:hm.get(v)){
                    if(!vis[z]){
                        vis[z]=true;
                    q.add(new int[]{z,steps});}
                }
                }
            
        }
        return -1;
    }
}