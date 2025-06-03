class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public int atMostK(int nums[], int k){
        int n = nums.length;
        int cnt = 0;
        int i=0; int j=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j<n){
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0)+1);
            while(map.size() > k){
                int x = nums[i];
                if(map.containsKey(x)){
                    map.put(x, map.get(x)-1);
                    if(map.get(x) == 0){
                        map.remove(x);
                    }
                }
                i++;
            }
            cnt += j-i+1;
            j++;
        }
        return cnt;
    }
}
