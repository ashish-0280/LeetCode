class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for(int i=low; i<=high; i++){
            if(check(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean check(int n){
        List<Integer> list = new ArrayList<>();
        int num = n; int sum = 0; int sum1 = 0;
        while(!(num == 0)){
            int rem = num%10;
            list.add(rem);
            sum += rem;
            num = num/10;
        }
        if(list.size() % 2 != 0){
            return false;
        }
        for(int i=0; i<list.size()/2; i++){
            sum1 += list.get(i);
        }
        int sum2 = sum - sum1;
        return sum1 == sum2;
    }
}