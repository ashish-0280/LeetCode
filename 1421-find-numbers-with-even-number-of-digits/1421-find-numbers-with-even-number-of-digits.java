class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int num: nums){
            String str = String.valueOf(num);
            if(str.length() % 2 == 0){
                cnt++;
            }
        }
        return cnt;
    }
}