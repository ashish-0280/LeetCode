class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        for(int num: fruits){
            for(int i=0; i<baskets.length; i++){
                if(baskets[i] >= num){
                    baskets[i] = 0;
                    cnt++;
                    break;
                }
            }
        }
        return fruits.length - cnt;
    }
}