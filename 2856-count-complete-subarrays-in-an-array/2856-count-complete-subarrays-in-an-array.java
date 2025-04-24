class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int distinct = set.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0; int j=0; int n = nums.length; int cnt = 0;
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size() == distinct){
                cnt += n-j;
                int num = nums[i];
                if(map.containsKey(num)){
                    map.put(num, map.get(num)-1);
                }
                if(map.get(num) == 0){
                    map.remove(num);
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
}