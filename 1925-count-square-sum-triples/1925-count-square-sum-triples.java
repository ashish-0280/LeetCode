class Solution {
    public int countTriples(int n) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++) set.add(i*i);
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int c = i*i + j*j;
                if(set.contains(c)){
                    count++;
                }
            }
        }
        return count;
    }
}