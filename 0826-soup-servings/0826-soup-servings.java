class Solution {
    Map<String, Double> map;
    public double soupServings(int n) {
        if(n > 10000) return 1.0;
        map = new HashMap<>();
        return solve(n, n);
    }
    public double solve(int x, int y){
        if(x<=0 && y<=0){
            return 0.5;
        }
        if(x<=0){
            return 1.0;
        }
        if(y<=0){
            return 0.0;
        }
        String key = x + "$" + y;
        if(map.containsKey(key)){
            return map.get(key);
        }
        double ans = solve(x-100, y) + solve(x-75, y-25) + solve(x-50, y-50) + solve(x-25, y-75);
        map.put(key, ans*0.25);
        return ans * 0.25;
    }
}