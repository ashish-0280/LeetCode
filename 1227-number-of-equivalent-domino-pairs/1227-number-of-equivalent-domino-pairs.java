class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int val = Math.min(dominoes[i][0],dominoes[i][1])*10 + Math.max(dominoes[i][0], dominoes[i][1]);
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        int cnt = 0;
        for(int value: map.values()){
            cnt += ((value-1) * value)/2;
        }
        return cnt;
    }
}