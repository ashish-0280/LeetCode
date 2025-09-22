class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max = 0; int cnt = 0;
        int freq[] = new int[101];
        for(int num: nums){
            freq[num]++;
            if(freq[num] == max){
                cnt++;
            } else if(freq[num] > max){
                max = freq[num];
                cnt = 1;
            }
        }
        return cnt*max;
    }
}