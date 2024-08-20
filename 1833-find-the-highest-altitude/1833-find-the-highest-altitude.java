class Solution {
    public int largestAltitude(int[] gain) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=0; i<gain.length; i++){
            list.add(list.get(i) + gain[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }
}