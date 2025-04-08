class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        int cnt = 0;
        while(!isDistinct(list)){
            if(list.size()<3){
                return cnt+1;
            }
            list.remove(0);
            list.remove(0);
            list.remove(0);
            cnt++;
        }
        return cnt;
    }
    public boolean isDistinct(List <Integer> list){
        Set<Integer> set = new HashSet<>();
        for(int num: list){
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }
        return true;
    }
}