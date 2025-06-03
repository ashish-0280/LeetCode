class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num: hand){
            list.add(num);
        }
        Collections.sort(list);
        while(!list.isEmpty()){
            int num = list.get(0);
            for(int i=0; i<groupSize; i++){
                if(!map.containsKey(num)){
                    return false;
                }
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
                list.remove(Integer.valueOf(num));
                num++;
            }
        }
        return true;
    }
}