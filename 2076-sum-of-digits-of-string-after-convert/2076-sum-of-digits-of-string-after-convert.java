class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for(int i=0; i<s.length(); i++){
            int a = s.charAt(i)-96;
            if(a > 9){
                int rem = a%10;
                int prev = a/10;
                a = rem + prev;
            }
            num += a;
        }
        while(k>1){
            num = sumOfDigit(num);
            k--;
        }
        return num;
    }
    public int sumOfDigit(int num){
        int sum = 0;
        while(num > 0){
            int rem = num%10;
            num = num/10;
            sum += rem;
        }
        return sum;
    }
}