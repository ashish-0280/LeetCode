class Solution {
    public List<Integer> grayCode(int n) {
        List <Integer> result = new ArrayList<>();
        HashSet <Integer> visited = new HashSet<>();
        result.add(0);
        visited.add(0);
        solve(n, result, visited);
        return result;
    }
    public boolean solve(int n, List<Integer> result, Set<Integer> visited){
        if(result.size() == (1<<n)){
            return true;
        }
        int current = result.get(result.size()-1);
        for(int i=0; i<n; i++){
            int next = current ^ (1<<i);
            if(!visited.contains(next)){
                visited.add(next);
                result.add(next);
                if(solve(n, result, visited)){
                    return true;
                }
                visited.remove(next);
                result.remove(result.size()-1);
            }
        }
        return false;
    }
}