class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            dfs(list, i, n-1, k);
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    public void dfs(List<Integer> list, int num, int n, int k){
        if(n==0){
            list.add(num);
            return;
        }
        int lastdigit = num%10;
        if(lastdigit + k <= 9) dfs(list, num*10 + lastdigit + k, n-1, k);
        if(k!=0 && lastdigit - k >= 0) dfs(list, num*10 + lastdigit - k, n-1, k);
    }
}