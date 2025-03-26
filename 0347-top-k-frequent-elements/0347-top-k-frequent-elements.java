class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int arr[][] = new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr[i][1] = entry.getKey();
            arr[i][0] = entry.getValue();
            i++;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(b[0], a[0]));
        int result[] = new int[k]; int j=0;
        while(k > 0){
            result[j] = arr[j][1];
            k--; j++;
        }
        return result;
    }
}