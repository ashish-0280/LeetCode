class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int product = nums[i] * nums[j];
                if(map.containsKey(product)){
                    int freq = map.get(product);
                    cnt += freq*8;
                    map.put(product, freq+1);
                } else {
                    map.put(product, 1);
                }
            }
        }
        return cnt;
    }
}