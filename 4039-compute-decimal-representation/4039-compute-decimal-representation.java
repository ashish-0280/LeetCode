class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> l = new ArrayList<>();
        int i=0;
        while(n > 0){
            int rem = n%10;
            int x = rem*(int)Math.pow(10, i);
            if(x != 0){
                l.add(x);
            }
            n /= 10;
            i++;
        }
        Collections.reverse(l);
        int ans[] = new int[l.size()];
        for(int j=0; j<ans.length; j++){
            ans[j] = l.get(j);
        }
        return ans;
    }
}