class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0){
            return arr;
        }
        int ans[] = new int[arr.length];
        int nums[][] = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            nums[i][0] = i;
            nums[i][1] = arr[i];
        }
        Arrays.sort(nums, Comparator.comparingDouble(o -> o[1]));
        int rank = 1;
        ans[nums[0][0]] = rank;
        for(int i=1; i<arr.length; i++){
           if(nums[i][1] == nums[i-1][1]){
            ans[nums[i][0]] = ans[nums[i-1][0]];
            continue;
           }
           ans[nums[i][0]] = ans[nums[i-1][0]]+1;
        }
        return ans;
    }
}