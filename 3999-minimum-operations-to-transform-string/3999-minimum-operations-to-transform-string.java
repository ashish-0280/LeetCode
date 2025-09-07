class Solution {
    public int minOperations(String s) {
        Set <Character> set = new HashSet<>();
        for(char ch: s.toCharArray()){
            set.add(ch);
        }
        int ops = 0;
        List<Integer> list = new ArrayList<>();
        for(char ch: set){
            list.add(ch-'a');
        }
        Collections.sort(list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) == 0) continue;
            ops += list.get(i+1) - list.get(i);
        }
            ops += (26 - list.get(list.size()-1))%26;
        return ops;
    }
}