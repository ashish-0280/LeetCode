class Solution {
    public int[] minOperations(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=1; i<=5000; i++){
            String s = Integer.toBinaryString(i);
            if(!solve(s)) continue;
            l.add(i);
        }
        int m = l.size();
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 5000);
        for(int i=0; i<n; i++){
            int low = 0; int high = m-1;
            while(low <= high){
                int mid = (low + high)/2;
                if(nums[i] == l.get(mid)){
                    ans[i] = 0; break;
                } else if(nums[i] < l.get(mid)){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            if(ans[i] != 0) {
                if(low < m) ans[i] = Math.min(ans[i], Math.abs(nums[i] - l.get(low)));
                if(high >= 0) ans[i] = Math.min(ans[i], Math.abs(l.get(high) - nums[i]));
            }
        }
        return ans;

    }
    public boolean solve(String s){
        int l = 0; int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
}