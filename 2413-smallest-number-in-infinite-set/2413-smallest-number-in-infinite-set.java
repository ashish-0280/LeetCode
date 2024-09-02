class SmallestInfiniteSet {
    HashSet <Integer> set;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
        for(int i=1; i<1001; i++){
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int min = Integer.MAX_VALUE;
        Iterator<Integer> itr = set.iterator();    
        while(itr.hasNext()){    
           min = Math.min(min, itr.next()); 
        }  
        set.remove(min);
        return min;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */