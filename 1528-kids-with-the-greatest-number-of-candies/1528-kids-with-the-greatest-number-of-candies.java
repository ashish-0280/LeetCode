class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList <Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<candies.length; i++){
            if(max<candies[i]){
                max = candies[i];
            }
        }
        for(int i=0; i<candies.length; i++){
            list.add(candies[i] + extraCandies >= max);
        }
        return list;
    }
}