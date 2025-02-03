class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int data1 = solve(nums);
        int i=0;
        int j=nums.length-1;
        int data2 = solvee(nums);
        
        return Math.max(data1, data2);
    }
    public int solve(int[] nums) {
        int i=0; int j=1;
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        while(j<nums.length){
            int data = nums[i];
            //System.out.println(data);
            if(data < nums[j]){
                cnt++; 
                //System.out.print(cnt);
                max = Math.max(max, cnt);
                i++;
            } else {
                cnt = 1;
                i = j;
            }
            j++;
        }
        return Math.max(cnt, max);
    }
    public int solvee(int[] nums) {
        int i=nums.length-1; int j=nums.length-2;
        int cnt = 1;
        int max = Integer.MIN_VALUE;
        while(j>=0){
            int data = nums[i];
            //System.out.println(data);
            if(data < nums[j]){
                cnt++; 
                //System.out.print(cnt);
                max = Math.max(max, cnt);
                i--;
            } else {
                cnt = 1;
                i = j;
            }
            j--;
        }
        return Math.max(cnt, max);
    }
}