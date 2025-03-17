class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int ans[] = new int[groups.length];
        for(int i=0; i<elements.length; i++){
            map.putIfAbsent(elements[i], i);
        }
        for(int i=0; i<groups.length; i++){
            ans[i] = solve(groups[i], map);
        }
        return ans;
    }
    public int solve(int num, HashMap<Integer, Integer> map){
        int minIdx = Integer.MAX_VALUE-1;
        for(int i=1; i*i<=num; i++){
            if(num % i == 0){
                if(map.containsKey(i)){
                    minIdx = Math.min(minIdx, map.get(i));
                }
                if(i != num/i && map.containsKey(num/i)){
                    minIdx = Math.min(minIdx, map.get(num/i));
                }
            }
        }
        return (minIdx == Integer.MAX_VALUE-1) ? -1 : minIdx;
    }
}