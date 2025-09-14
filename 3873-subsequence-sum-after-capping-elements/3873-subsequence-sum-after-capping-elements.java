class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int K) {
        Arrays.sort(nums);
        int n=nums.length;
        HashSet<Integer> sums=new HashSet<Integer>();
        boolean[] ans=new boolean[n];
        sums.add(0);
        int j=0;
        for(int i=1;i<=n;i++){
            while(j<n&&nums[j]<=i){
                ArrayList<Integer> temp=new ArrayList<Integer>(sums);
                {
                for(int k:temp)
                    if(k+nums[j]<=K)
                        sums.add(k+nums[j]);
            j++;
            }}
            if(sums.contains(K))
                ans[i-1]=true;
            else{
                for(int k=j;k<n;k++)
                    if(sums.contains(K-(k-j+1)*i)){
                        ans[i-1]=true;
                        break;}
            }
        }
        return ans;
    }
}