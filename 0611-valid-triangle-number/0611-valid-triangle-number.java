class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums); int n = nums.length; int cnt = 0;
        int i=0; int j=1; int k=nums.length-1;
        while(k > 1){
            i=0;
            while(i < k-1){
                j=i+1;
                while(j <k){
                    int sum = nums[i] + nums[j];
                    if(sum > nums[k]){
                        cnt += k-j;
                        break;
                    }
                    j++;
                }
                i++;
            }
            k--;
        }
        return cnt;
    }
}