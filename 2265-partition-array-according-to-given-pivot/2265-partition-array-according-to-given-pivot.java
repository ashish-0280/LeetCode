class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int num: nums){
            if(num < pivot){
                list.add(num);
            } else if(num == pivot){
                cnt++;
            }
        }
        for(int i=0; i<cnt; i++){
            list.add(pivot);
        }
        for(int num: nums){
            if(num>pivot){
                list.add(num);
            }
        }
        int ans[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}