class NumberContainers {
    HashMap <Integer, Integer> map;
    HashMap <Integer, TreeSet<Integer>> map2;
    public NumberContainers() {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map.containsKey(index)){
            int prev = map.get(index);
            if(map2.containsKey(prev)){
                map2.get(prev).remove(index);
                if(map2.get(prev).isEmpty()){
                    map2.remove(prev);
                }
            }
        }
        map.put(index, number);
        map2.putIfAbsent(number, new TreeSet<>());
        map2.get(number).add(index);
    }
    
    public int find(int number) {
        if(map2.containsKey(number)){
            return map2.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */