class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = 0; int cnt = 0;
        int freq[] = new int[101];
        for(int num: nums){
            freq[num]++;
        }
        for(int num: freq){
            max = Math.max(max, num);
        }
        for(int num: freq){
            if(num == max){
                cnt++;
            }
        }
        return cnt*max;
    }
}