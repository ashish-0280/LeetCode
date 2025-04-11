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
    public boolean check(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if (len % 2 != 0) return false;

        int half = len / 2;
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < half; i++) {
            sum1 += s.charAt(i) - '0';
            sum2 += s.charAt(i + half) - '0';
        }

        return sum1 == sum2;
    }
}