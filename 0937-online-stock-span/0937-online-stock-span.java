class StockSpanner {
    List <Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        int ans = 0;
        list.add(price);
        int i = list.size()-1;
        while(i >= 0 && price >= list.get(i)){
            ans++;
            i--;
        }
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */