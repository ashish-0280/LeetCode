class Skiplist {
    List<Integer> list;
    public Skiplist() {
        list = new ArrayList<>();
    }
    
    public boolean search(int target) {
        int i=0; int j=list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(target == list.get(mid)){
                return true;
            } else if(target < list.get(mid)){
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return false;
    }
    
    public void add(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public boolean erase(int num) {
        int target = num;
        int i=0; int j=list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(target == list.get(mid)){
                list.remove(mid);
                return true;
            } else if(target < list.get(mid)){
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return false;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */