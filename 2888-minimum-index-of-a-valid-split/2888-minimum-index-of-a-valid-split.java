class Solution {
    public int minimumIndex(List<Integer> nums) {
        int element = solve(nums); int cnt = 0;
        int n = nums.size();
        for(int num: nums){
            if(element == num){
                cnt++;
            }
        }
        int cnt1 = 0;
        for(int i=0; i<nums.size(); i++){
            if(element == nums.get(i)){
                cnt1++;
            }
            if(cnt1 > (i+1)/2 && cnt-cnt1 > (n-(i+1))/2){
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