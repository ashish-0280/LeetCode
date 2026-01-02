class Solution {
    public int repeatedNTimes(int[] nums) {
        int freq[] = new int[10000];
        for(int num: nums){
            freq[num]++;
            if(freq[num] == 2){
                return num;
            }
        }
        return -1;
    }
}