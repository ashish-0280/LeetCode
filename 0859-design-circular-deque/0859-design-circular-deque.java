class MyCircularDeque {
    LinkedList<Integer> list;
    int p = 0;
    public MyCircularDeque(int k) {
        list = new LinkedList<>();
        p = k;
    }
    
    public boolean insertFront(int value) {
        if(list.size() == p){
            return false;
        }
        list.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(list.size() == p){
            return false;
        }
        list.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(list.size() == 0){
            return false;
        }
        list.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if(list.size() == 0){
            return false;
        }
        list.removeLast();
        return true;
    }
    
    public int getFront() {
        if(list.size() == 0){
            return -1;
        }
        return list.getFirst();
    }
    
    public int getRear() {
        if(list.size() == 0){
            return -1;
        }
        return list.getLast();
    }
    
    public boolean isEmpty() {
        if(list.size() == 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(list.size() == p){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */