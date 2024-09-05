class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[] = new int[n];
        int totalSum = mean * (rolls.length + n);
        int leftSum = totalSum - calculateSum(rolls);
        if(leftSum < 0){
            return new int[0];
        }
        int p = leftSum/n;
        int rem = leftSum % n;
        if(p>6 || p==0){
            return new int[0];
        }
        if(p == 6 && rem != 0){
            return new int[0];
        }
        for(int i=0; i<ans.length; i++){
            ans[i] = p;
        }
        if(rem == 0){
            return ans;
        }
        for(int i=0; i<rem; i++){
            ans[i]++;
        }
        return ans;
    }
    public int calculateSum(int arr[]){
        int sum = 0;
        for(int num: arr){
            sum += num;
        }
        return sum;
    }
}