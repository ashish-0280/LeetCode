class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            Arrays.sort(dominoes[i]);
            List<Integer> list = Arrays.asList(dominoes[i][0], dominoes[i][1]);
            map.put(list, map.getOrDefault(list, 0)+1);
        }
        System.out.println(map);
        int cnt = 0;
        for(Map.Entry<List<Integer>, Integer> entry: map.entrySet()){
            int val = entry.getValue()-1;
            while(val != 0){
                cnt += val;
                val--;
            }
        }
        return cnt;
    }
}