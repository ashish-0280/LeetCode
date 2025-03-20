class Solution {
    public String getPermutation(int n, int k) {
        ArrayList <Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int factorial = 1;
        for(int i=1; i<n; i++){
            list.add(i);
            factorial *= i;
        }
        list.add(n); k--;
        for(int i=n; i>0; i--){
            int idx = k/factorial;
            result.append(list.get(idx));
            list.remove(idx);
            if(i > 1){
                k = k % factorial;
                factorial = factorial/(i-1);
            }
        }
        return result.toString();
    }
}