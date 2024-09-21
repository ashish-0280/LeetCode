class Solution {
    public List<Integer> lexicalOrder(int n) {
        List <Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            solve(i, n, list);
        }
        // Collections.sort(list, new Comparator<Integer>(){
        //     @Override
        //     public int compare(Integer a, Integer b){
        //         return a.toString().compareTo(b.toString());
        //     }
        // });
        return list;
    }
    public void solve(int curr, int limit, List<Integer> list){
        if(curr > limit){
            return;
        } else {
            list.add(curr);
            for(int i=0; i<=9; i++){
                int nextNum = 10 * curr + i;
                if(nextNum <= limit){
                    solve(nextNum, limit, list);
                } else {
                    break;
                }
            }
        }
    }
}