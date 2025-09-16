class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Long> stk = new Stack<>();
        stk.push((long)nums[0]);
        for(int i=1; i<n; i++){
            long gcd = gcd(stk.peek(), (long)nums[i]);
            if(gcd == 1){
                stk.push((long)nums[i]);
            } else {
                long lcm = (nums[i] * stk.pop())/gcd;
                if(!stk.isEmpty()) gcd = gcd(stk.peek(), lcm);
                while(!stk.isEmpty() && gcd != 1){
                    lcm = (lcm * stk.pop())/gcd;
                    if(!stk.isEmpty()) gcd = gcd(stk.peek(), lcm);
                }
                stk.push(lcm);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!stk.isEmpty()){
            long val = stk.pop();
            list.add((int)(val));
        }
        Collections.reverse(list);
        return list;
    }
    public long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}