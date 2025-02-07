class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map <Integer, Integer> map = new HashMap<>();
        Map <Integer, Integer> freq = new HashMap<>();
        int cnt = 0;
        int arr[] = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int data = queries[i][0];
            int color = queries[i][1];
            if(map.containsKey(data)){
                int prevColor = map.get(data);
                if(prevColor == color){
                    arr[i] = cnt;
                    continue;
                }    
                freq.put(prevColor, freq.get(prevColor)-1);
                if(freq.get(prevColor) == 0){
                    freq.remove(prevColor);
                    cnt--;
                }
            }
            map.put(data, color);
            
            freq.put(color, freq.getOrDefault(color, 0)+1);
            if(freq.get(color) == 1){
                cnt++;
            }
            arr[i] = cnt;
        }
        return arr;
    }
}