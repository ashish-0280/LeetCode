class ProductOfNumbers {
    List<Integer> list;
    int c;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        c = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>();
            c = 1;
            return;
        }
        c = c*num;
        list.add(c);
    }
    
    public int getProduct(int k) {
        if(k>list.size()){
            return 0;
        }
        if(k == list.size()){
            return list.get(list.size()-1);
        }
        return list.get(list.size()-1)/list.get(list.size()-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */