class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int ans = 0;
        long sum = 0;
        for(int i=0; i<chalk.length; i++){
            sum += chalk[i];
        }
        sum = (long)k%sum;
        for(int i=0; i<chalk.length; i++){
            sum = sum-chalk[i];
            if(sum<0){
                return i;
            }
        }
        return 0;
    }
}