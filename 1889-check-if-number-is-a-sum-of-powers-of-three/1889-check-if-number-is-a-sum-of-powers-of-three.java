class Solution {
    public boolean checkPowersOfThree(int n) {
        int num = n;
        while(num != 0){
            if(num % 3 != 0){
                num = num-1;
                if(num % 3 != 0){
                    return false;
                }
            }
            num = num/3;
        }
        return true;
    }
}