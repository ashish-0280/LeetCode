class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int n = nums.size(); int x1 = 0; int x2 = 0;
        int element = solve(nums);
        for(int num: nums){
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }
        for(int i=0; i<nums.size()-1; i++){
            map1.put(nums.get(i), map1.getOrDefault(nums.get(i), 0)+1);
            map2.put(nums.get(i), map2.get(nums.get(i))-1);
            if(map2.get(nums.get(i)) == 0){
                map2.remove(nums.get(i));
            }
            if(map1.containsKey(element) && (map1.get(element) > (i+1)/2) && map2.containsKey(element) && (map2.get(element) > (n-(i+1))/2)){
                return i;
            }
        }
        return -1;
    }
    public int solve(List<Integer> list){
        int element = -1;
        int cnt = 0;
        for(int num: list){
            if(cnt == 0){
                element = num;
                cnt++;
            } else if(element == num){
                cnt++;
            } else if(element != num && cnt > 0){
                cnt--;
            }
        }
        return element;
    }
}